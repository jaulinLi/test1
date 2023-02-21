package com.itheima.demo02collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo04Contains {

    public static void main(String[] args) {
        //List<String> list = List.of("张三", "李四", "王五", "钱六");
        ArrayList<String> al = new ArrayList<>();
        Collections.addAll(al, "张三", "李四", "王五", "钱六");
        boolean result = listText(al, "李梅");
        System.out.println(result);
    }

    public static boolean listText(ArrayList<String> al, String str) {
        boolean b = al.contains(str);
        return b;
    }
}
