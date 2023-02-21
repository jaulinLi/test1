package com.pinyougou.test;

import com.pinyougou.solr.SolrUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;


public class SolrImortTest {


    private SolrUtil solrUtil;

    @Before
    public void init(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-solr.xml");

        solrUtil = ac.getBean(SolrUtil.class);
    }

    @Test
    public  void  testAdd(){
        solrUtil.bathInsert();
    }

}
