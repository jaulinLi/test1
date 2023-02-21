package com.itheima.demo05changliang;

public class Demo02Change {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("互换前：");
        System.out.println(a);
        System.out.println(b);

        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println("互换后：");
        System.out.println(a);
        System.out.println(b);
    }
}
