package com.itheima.demo08Data;

public class Test5 {

    public static void main(String[] args) {
        int a = 20;
        int b = 20;
        boolean bo = ++a % 3 == 0 && a++ % 7 == 0;
        System.out.println("bo的值：" + bo);
        System.out.println("a的值：" + a); //为什么是22
        System.out.println("=====================");

        boolean bo2 = b++ % 3 == 0 && ++b % 7 == 0;
        System.out.println("bo2的值：" + bo2);
        System.out.println("b的值：" + b);
    }
}
