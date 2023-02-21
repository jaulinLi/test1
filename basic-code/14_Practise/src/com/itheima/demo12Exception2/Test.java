package com.itheima.demo12Exception2;

public class Test {

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
        System.out.println("mian:");

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }
    }
}