package com.itheima.demo08Data;

public class Test4 {

    public static void main(String[] args) {
        int a = 10;
        int b = 11;
        boolean b1 = a % 2 == 0;
        boolean b2 = b % 2 == 0;
        System.out.println("10是偶数？" + b1);
        System.out.println("11是偶数？" + b2);

        int c = 12;
        int d = 13;
        boolean b3 = !(c % 2 == 0);
        boolean b4 = !(d % 2 == 0);
        System.out.println("12是奇数？" + b3);
        System.out.println("13是奇数？" + b4);
    }
}
