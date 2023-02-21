package com.itheima.demo08Data;

public class Test9 {

    public static void main(String[] args) {
        printString();
    }

    public static void printString() {
        String str;
        int num = 69;
        str = num % 2 == 0 ? "偶数" : "奇数";
        System.out.println("num:69是" + str);
    }
}
