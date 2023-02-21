package com.itheima.demo11RandomAndArrayList;

import java.util.ArrayList;

public class Demo06MyList {

    public static void main(String[] args) {
        ArrayList<Integer> list = show();
        add(list);
        remove(list);
    }

    public static ArrayList<Integer> show() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        return list;
    }

    public static void add(ArrayList<Integer> al) {
        al.add(2);
        System.out.println("添加元素后：");
        System.out.println(al);
    }

    public static void remove(ArrayList<Integer> al) {
        Integer i = al.remove(2);
        System.out.println("获取到的元素：");
        System.out.println(i);
        System.out.println("获取元素后：");
        System.out.println(al);
    }
}
