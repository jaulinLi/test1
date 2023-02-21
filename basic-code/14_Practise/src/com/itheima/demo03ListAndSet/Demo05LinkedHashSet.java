package com.itheima.demo03ListAndSet;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class Demo05LinkedHashSet {

    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("王昭君");
        lhs.add("王昭君");
        lhs.add("西施");
        lhs.add("杨玉环");
        lhs.add("貂蝉");
        System.out.println(lhs);

        Iterator<String> it = lhs.iterator();
        while (it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }

        for (String str : lhs) {
            System.out.println(str);
        }
    }
}
