package com.itheima.demo05Text;

import java.util.ArrayList;

public class Demo04CollectionText4 {

    public static void main(String[] args) {

        ArrayList<String> array = new ArrayList<>();
        array.add("Hello");
        array.add("World");
        array.add("Java");
        method(array);

    }

    public static boolean method(ArrayList<String> al){
        boolean result = al.isEmpty();
        System.out.println(result);
        return result;

    }
}
