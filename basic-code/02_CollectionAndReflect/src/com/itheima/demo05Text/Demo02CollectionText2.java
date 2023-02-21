package com.itheima.demo05Text;

import java.util.ArrayList;
import java.util.Collection;

public class Demo02CollectionText2 {

    public static void main(String[] args) {
        Collection<Integer> coll = new ArrayList<>();
        coll.add(100);
        coll.add(200);
        coll.add(300);
        coll.add(400);
        coll.add(500);

        Object[] obj = coll.toArray();
        for (int i = 0; i < obj.length; i++) {
        System.out.println(obj[i]);
        }
    }
}
