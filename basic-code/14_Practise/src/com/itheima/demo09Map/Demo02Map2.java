package com.itheima.demo09Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo02Map2 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("张三", "女");
        map.put("李四", "女");
        map.put("王五", "男");
        map.put("钱六", "女");
        map.put("小明", "男");
        System.out.println(map);

        /*Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry<String, String> entry : set) {
            String value = entry.getValue();
            System.out.println(value);
        }
        System.out.println("==========================");*/

        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator<Map.Entry<String, String>> it = set.iterator();
        while (it.hasNext()) {
            String value = it.next().getValue();
            System.out.println(value);
        }
    }
}
