package com.itheima.demo07Interface3;

public class B implements A {

    public static void showD() {
        System.out.println("DDDD");
    }

    @Override
    public void showA() {
        System.out.println("AAA");
    }
}
