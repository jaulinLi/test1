package com.itheima.demo03ListAndSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo06Collections {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,33,11,77,55);
        //Collections.sort(list);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println(list);


    }
}
