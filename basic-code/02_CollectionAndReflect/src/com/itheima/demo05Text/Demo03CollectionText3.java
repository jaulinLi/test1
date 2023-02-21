package com.itheima.demo05Text;

import java.util.ArrayList;
import java.util.Collection;

public class Demo03CollectionText3 {

    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("hello");
        coll.add("world");
        System.out.println(listText(coll,"Java"));

    }
    public static boolean listText(Collection<String> coll2,String s){
        if(coll2.contains(s)){
            return true;
        }
            return false;
    }
}
