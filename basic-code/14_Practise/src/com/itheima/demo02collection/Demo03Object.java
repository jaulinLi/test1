package com.itheima.demo02collection;

import java.util.ArrayList;
import java.util.Collections;

public class Demo03Object {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        Collections.addAll(array, 10, 20, 30, 40, 50);
        Object[] obj = array.toArray();
        for (Object o : obj) {
            System.out.println(o);
        }
    }
}