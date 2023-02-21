package cn.itheima;

import cn.itheima.dao.ItemsDao;
import cn.itheima.domain.Items;
import cn.itheima.service.ItemsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void run1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ItemsDao itemsDao = ac.getBean(ItemsDao.class);
        Items item = itemsDao.findItemsById(1);
        System.out.println(item.getName());
    }
    @Test
    public void run2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ItemsService itemsService = ac.getBean(ItemsService.class);
        Items items = itemsService.findItemsById(1);
        System.out.println(items.getName());
    }
}
