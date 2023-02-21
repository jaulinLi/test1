package com.itheima.demo03ListAndSet;

import java.util.ArrayList;
import java.util.List;

public class Demo04List {

    public static void main(String[] args) {
        //List<String> list = List.of("张三", "李四","王五","二丫","钱六","孙七");
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("二丫");
        list.add("钱六");
        list.add("孙七");
        String str = list.set(3, "王小丫");
        System.out.println("被替换的是：" + str);
        System.out.println(list);

    }
}
