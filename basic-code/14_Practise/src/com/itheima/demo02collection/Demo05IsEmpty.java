package com.itheima.demo02collection;

import java.util.ArrayList;
import java.util.Collections;

public class Demo05IsEmpty {

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        Collections.addAll(al, "a", "b", "c");
        boolean result = listTest(al);
        System.out.println(result);
    }

    public static boolean listTest(ArrayList<String> al) {
        boolean b = al.isEmpty();
        return b;
    }
}
