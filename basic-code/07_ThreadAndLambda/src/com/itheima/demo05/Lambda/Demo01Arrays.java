package com.itheima.demo05.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
    Lambda表达式有参数有返回值的练习
    需求:
        使用数组存储多个Person对象
        对数组中的Person对象使用Arrays的sort方法通过年龄进行升序排序
 */
public class Demo01Arrays {

    public static void main(String[] args) {
        Person[] arr = {
                new Person("张三", 18),
                new Person("李四", 19),
                new Person("王五", 20)
        };
        /*Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });*/

        Arrays.sort(arr,(Person o1, Person o2)->{
            return o1.getAge()-o2.getAge();
        });
        //省略
        // Arrays.sort(arr,( o1, o2)-> o1.getAge()-o2.getAge());

        for (Person person : arr) {
            System.out.println(person);
        }

    }
}
