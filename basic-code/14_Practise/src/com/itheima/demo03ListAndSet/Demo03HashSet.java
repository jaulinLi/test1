package com.itheima.demo03ListAndSet;

import java.util.HashSet;

public class Demo03HashSet {

    public static void main(String[] args) {
        Person person1 =new Person("张三",18);
        Person person2 =new Person("李四",18);
        Person person3 =new Person("张三",20);
        Person person4 =new Person("王五",21);
        Person person5 =new Person("张三",18);
        HashSet<Person> hs = new HashSet<>();
        hs.add(person1);
        hs.add(person2);
        hs.add(person3);
        hs.add(person4);
        hs.add(person5);
        System.out.println(hs);
    }
}
