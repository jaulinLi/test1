package com.itheima.demo13Thread;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("我是子线程");
    }
}
