package com.itheima.demo08Data;

public class Test10 {

    public static void main(String[] args) {
        int x = 100;
        int y = 200;
        add(x, y);
        sub(x, y);
        mul(x, y);
        div(x, y);
        remain(x, y);

    }

    private static void remain(int x, int y) {
        System.out.println("x,y的余数为：" + (x % y));
    }

    private static void div(int x, int y) {
        System.out.println("x,y的商为：" + (x / y));
    }

    private static void mul(int x, int y) {
        System.out.println("x,y的积为：" + (x * y));
    }

    private static void sub(int x, int y) {
        System.out.println("x,y的差数为：" + (x - y));
    }

    private static void add(int x, int y) {
        System.out.println("x,y的和为：" + (x + y));
    }


}
