package com.itheima.demo13Runnable;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("子线程任务执行");
    }
}
