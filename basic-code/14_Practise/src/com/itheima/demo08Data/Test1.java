package com.itheima.demo08Data;

public class Test1 {

    public static void main(String[] args) {
        byte b1 = 10;
        byte b2 = 20;
        int b3 = b1 + b2;
        System.out.println("byte类型b1，b2的和为：");
        System.out.println(b3);

        short s1 = 1000;
        short s2 = 2000;
        short s3 = (short) (s1 + s2);
        System.out.println("short类型s1，s2的和为：");
        System.out.println(s3);

        char c1 = 'a';
        int i1 = 30;
        int c3 = c1 - i1;
        System.out.println("char类型c1，int类型i1的差为：");
        System.out.println(c3);
    }
}
