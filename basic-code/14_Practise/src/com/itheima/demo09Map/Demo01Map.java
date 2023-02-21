package com.itheima.demo09Map;

import java.util.HashMap;
import java.util.Map;

public class Demo01Map {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("张三","女");
        map.put("李四","女");
        map.put("王五","男");
        System.out.println(map);

        String s = map.get("张三");
        String s2 = map.get("李梅梅");
        System.out.println(s);
        System.out.println(s2);

        String s3 = map.remove("李四");
        System.out.println(s3);
        System.out.println(map);
    }
}
