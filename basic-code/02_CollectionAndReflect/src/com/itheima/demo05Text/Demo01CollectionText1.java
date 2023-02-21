package com.itheima.demo05Text;

import java.util.ArrayList;
import java.util.Collection;

public class Demo01CollectionText1 {

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5, 6};
        Collection<Integer> result = method(list);
        System.out.println(result);

    }

    public static Collection<Integer> method(int[] list) {
        Collection<Integer> coll = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {

            coll.add(i);
//            System.out.println(coll);
        }
        return coll;
    }
}
