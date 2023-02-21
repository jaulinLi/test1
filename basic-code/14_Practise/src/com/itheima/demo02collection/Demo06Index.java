package com.itheima.demo02collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Demo06Index {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        Collections.addAll(al, 100, 200, 300, 400);
        int i = listText(al, 500);
        System.out.println(i);
    }

    public static int listText(ArrayList<Integer> al, Integer s) {
        if (al.contains(s)) {
            return al.indexOf(s);
        } else {
            return -1;
       }
    }
}
