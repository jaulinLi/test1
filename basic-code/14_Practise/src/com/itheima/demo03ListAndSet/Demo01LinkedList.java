package com.itheima.demo03ListAndSet;

import java.util.LinkedList;

public class Demo01LinkedList {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list);

        String s1 = list.set(1, "B");
        System.out.println(s1);
        System.out.println(list);

        String s2 = list.get(2);
        System.out.println(s2);
        System.out.println(list);

        String s3 = list.remove(3);
        System.out.println(s3);
        System.out.println(list);

        System.out.println(list.size());

        list.clear();
        System.out.println(list);
    }
}
