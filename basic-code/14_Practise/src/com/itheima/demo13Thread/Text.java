package com.itheima.demo13Thread;

public class Text {

    public static void main(String[] args) {

        MyThread mt = new MyThread();
        mt.start();
        System.out.println("我是主线程");
    }
}
