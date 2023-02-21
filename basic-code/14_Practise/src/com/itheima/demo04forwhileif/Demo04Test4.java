package com.itheima.demo04forwhileif;

public class Demo04Test4 {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 30;
        method1();
        method2();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static void method1() {
        int a = -5;
        int b = --a;
        if (a % 2 == 0) {
            a = ++b;
        } else {
            b = --a;
        }
        System.out.println(a);
        System.out.println(b); //为什么是-5，我觉得是-6
        System.out.println("================");
    }

    public static void method2() {
        int a = 0;
        while (a <= 5) {
            for (int b = 1; b <= 5; b++) {
                System.out.print(b + " ");
            }
            System.out.println();
            a++;
        }
        System.out.println("===================");
    }
}
