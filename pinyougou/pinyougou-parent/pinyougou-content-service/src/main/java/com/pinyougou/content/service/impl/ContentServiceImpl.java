package com.pinyougou.content.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.content.service.ContentService;
import com.pinyougou.mapper.ContentMapper;
import com.pinyougou.model.Content;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Content> findByCategoryId(long categoryId) {

        List<Content> ContentList = (List<Content>) redisTemplate.boundHashOps("ContentList").get(categoryId);
        //从数据库查
        if (ContentList == null) {
            Example example = new Example(Content.class);
            Example.Criteria criteria = example.createCriteria();

            criteria.andEqualTo("categoryId", categoryId);
            criteria.andEqualTo("status", "1");

            example.orderBy("sortOrder").asc();
            ContentList = contentMapper.selectByExample(example);
            //加入缓存
            redisTemplate.boundHashOps("ContentList").put(categoryId, ContentList);
        }
        return ContentList;
    }


    /**
     * 返回Content全部列表
     *
     * @return
     */
    @Override
    public List<Content> getAll() {
        return contentMapper.selectAll();
    }


    /***
     * 分页返回Content列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Content> getAll(Content content, int pageNum, int pageSize) {
        //执行分页
        PageHelper.startPage(pageNum, pageSize);

        //执行查询
        List<Content> all = contentMapper.select(content);
        PageInfo<Content> pageInfo = new PageInfo<Content>(all);
        return pageInfo;
    }


    /***
     * 增加Content信息
     * @param content
     * @return
     */
    @Override
    public int add(Content content) {
        //根据分类id到redis中删除对应分类广告
        int acount = contentMapper.insertSelective(content);
        if (acount > 0) {
            redisTemplate.boundHashOps("ContentList").delete(content.getCategoryId());
        }
        return acount;
    }


    /***
     * 根据ID查询Content信息
     * @param id
     * @return
     */
    @Override
    public Content getOneById(Long id) {
        return contentMapper.selectByPrimaryKey(id);
    }


    /***
     * 根据ID修改Content信息
     * @param content
     * @return
     */
    @Override
    public int updateContentById(Content content) {

        Content oldContent = contentMapper.selectByPrimaryKey(content.getId());
        int ucount = contentMapper.updateByPrimaryKeySelective(content);
        if (ucount > 0){
            redisTemplate.boundHashOps("ContentList").delete(oldContent.getCategoryId());

            if(oldContent.getCategoryId().longValue()!=content.getCategoryId().longValue()){
                redisTemplate.boundHashOps("ContentList").delete(content.getCategoryId());
            }
        }
        return ucount;
    }


    /***
     * 根据ID批量删除Content信息
     * @param ids
     * @return
     */
    @Override
    public int deleteByIds(List<Long> ids) {
        //创建Example，来构建根据ID删除数据
        Example example = new Example(Content.class);
        Example.Criteria criteria = example.createCriteria();

        //所需的SQL语句类似 delete from tb_content where id in(1,2,5,6)
        criteria.andIn("id", ids);
        List<Content> contents =contentMapper.selectByExample(example);

        //创建Example，来构建根据ID删除数据
        Example example1 = new Example(Content.class);
        Example.Criteria criteria1 = example.createCriteria();

        //所需的SQL语句类似 delete from tb_content where id in(1,2,5,6)
        criteria.andIn("id",ids);
        int dcount = contentMapper.deleteByExample(example1);

        //删除缓存
        if(dcount>0){
            for (Content content : contents) {
                redisTemplate.boundHashOps("ContentList").delete(content.getCategoryId());
            }
        }
        return dcount;
    }
}
