package com.itheima.demo13Runnable;

public class Test {

    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread thread = new Thread(mr);
        thread.start();

        System.out.println("主线程任务执行");
    }
}
