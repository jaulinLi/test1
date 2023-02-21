package com.itheima.demo12Exception2;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("zi:");
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}