package com.itheima.demo08Data;

public class Test8 {

    public static void main(String[] args) {
        printNum();
    }

    private static void printNum() {
        int i = 10;
        int j = 20;
        j += 10 / 5;
        int k = j;
        System.out.println("i:" + i + " j:" + j + " k:" + k);
    }
}
