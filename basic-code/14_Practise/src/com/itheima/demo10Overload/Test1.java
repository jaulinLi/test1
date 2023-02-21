package com.itheima.demo10Overload;

public class Test1 {

    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        printNum(a, b);
        doubling(a, b);
        printNum(a, b);
        int aa = doubling(a);
        int bb = doubling(b);
        System.out.println("====================");
        printNum(aa, bb);
    }

    public static void printNum(int ivar, int ivar2) {
        System.out.println("ivar:" + ivar + ",ivar2:" + ivar2);
    }

    public static void doubling(int r, int p) {
        r = 2 * r;
        p = 2 * p;
        System.out.println("翻倍：r =" + r + ",p =" + p);
    }

    public static int doubling(int r) {
        r = 2 * r;
        return r;
    }

}
