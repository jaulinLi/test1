package com.itheima.demo02collection;

import java.util.ArrayList;
import java.util.Collection;

public class Demo02IntChangeInteger {
    public static void main(String[] args) {
        int[] list = {1,2,3,4,5};
        Collection<Integer> co = listText(list);
        System.out.println(co);
    }

    public static Collection<Integer> listText(int[] list){
        Collection<Integer> co = new ArrayList<>();
        for (int i : list) {
            co.add(i);
        }
        return co;
    }
}
