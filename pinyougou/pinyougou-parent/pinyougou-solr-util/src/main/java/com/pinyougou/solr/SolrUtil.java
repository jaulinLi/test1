package com.pinyougou.solr;

import com.alibaba.fastjson.JSON;
import com.pinyougou.mapper.ItemMapper;
import com.pinyougou.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SolrUtil {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private SolrTemplate solrTemplate;

    public void bathInsert(){
        Item item = new Item();
        item.setStatus("1");
        List<Item> items = itemMapper.select(item);

        for (Item item1 : items) {
            String spec = item1.getSpec();
            Map<String,String> map = JSON.parseObject(spec, Map.class);
            item1.setSpecMap(map);
        }
        solrTemplate.saveBeans(items);
        solrTemplate.commit();
    }

    /***
     * 动态域搜索
     */
    public void queryByCondtion(String fieldName,String keywords){
        //创建Query指定查询条件
        Query query = new SimpleQuery();

        //增加条件
        Criteria criteria = new Criteria("item_spec_"+fieldName).is(keywords);

        //将条件对象给Query对象
        query.addCriteria(criteria);

        //指定分页参数
        query.setOffset(0);
        query.setRows(5);

        //执行分页搜索
        //Query：搜索条件的封装
        //Item.class:查询的数据结果集需要转换成Item
        ScoredPage<Item> scoredPage = solrTemplate.queryForPage(query, Item.class);

        //获取结果集
        List<Item> items = scoredPage.getContent();

        //总记录数
        long totalElements = scoredPage.getTotalElements();


        System.out.println("总记录数有："+totalElements);
        for (Item item : items) {
            System.out.println(item);
        }
    }
}
