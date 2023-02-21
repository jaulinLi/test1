package com.itheima.demo11RandomAndArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class Demo02 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 2, 1, 6, 5, 5, 8, 8, 9);
        findIndex(list);
        System.out.println("替换前:" + list);
        replace(list);
    }

    public static void findIndex(ArrayList<Integer> al) {
        int i = al.indexOf(2);
        System.out.println("2的索引是：" + i);
    }

    public static void replace(ArrayList<Integer> al) {
        String str = String.valueOf(al).replace("5", "55");
        System.out.println("替换后:" + str);
    }
}
