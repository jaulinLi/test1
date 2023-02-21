package com.itheima.demo02collection;

import java.util.ArrayList;
import java.util.Collection;

public class Demo01Count {
    public static void main(String[] args) {

        Collection<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        System.out.println("a:" + listTest("a", list));
        System.out.println("b:" + listTest("b", list));
        System.out.println("c:" + listTest("c", list));
        System.out.println("xxx:" + listTest("xxx", list));
    }

    public static int listTest(String str, Collection<String> co) {
        int count = 0;
        for (String s : co) {
            if (s == str) {
                //co.contains(str)
                count++;
            }
        }
        return count;
    }
}
