package com.pinyougou.page.service.impl;

import com.pinyougou.mapper.GoodsDescMapper;
import com.pinyougou.mapper.GoodsMapper;
import com.pinyougou.mapper.ItemMapper;
import com.pinyougou.model.Goods;
import com.pinyougou.model.GoodsDesc;
import com.pinyougou.model.Item;
import com.pinyougou.page.service.ItemPageService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import tk.mybatis.mapper.entity.Example;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemPageServiceImpl implements ItemPageService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsDescMapper goodsDescMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean;

    @Override
    public void deleteHtml(Long id) {
        File file = new File("D:/IdeaProjects/pinyougou/pinyougou-parent/pinyougou-page-service/src/main/webapp/"+id+".html");
        if (file.exists()){
            file.delete();
        }
    }

    @Override
    public Boolean buildHtml(long goodsId) throws Exception {

        Map<String,Object> dataMap = new HashMap<String, Object>();

        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        GoodsDesc goodsDesc = goodsDescMapper.selectByPrimaryKey(goodsId);

        List<Item> items = skuList(goodsId);

        dataMap.put("goods",goods);
        dataMap.put("goodsDesc",goodsDesc);
        //dataMap.put("items", JSON.toJSONString(items));
        dataMap.put("items", items);

        Configuration configuration = freeMarkerConfigurationFactoryBean.createConfiguration();

        Template template = configuration.getTemplate("item.ftl");

        //Writer writer = new FileWriter(new File("D:/IdeaProjects/pinyougou/pinyougou-parent/pinyougou-page-service/src/main/webapp/"+goodsId+".html"));
        //Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(HTML_PATH+goodsId+HTML_SUFFIX),"UTF-8"));
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:/IdeaProjects/pinyougou/pinyougou-parent/pinyougou-page-service/src/main/webapp/"+goodsId+".html"),"UTF-8"));

        template.process(dataMap,writer);

        writer.flush();
        writer.close();

        return true;
    }

    public List<Item> skuList(long goodsId){
        Example example = new Example(Item.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("status","1");
        criteria.andEqualTo("goodsId",goodsId);
        example.orderBy("isDefault").desc();

        return itemMapper.selectByExample(example) ;
    }
}
