package com.itheima.demo08Data;

public class Test3 {

    public static void main(String[] args) {
        char ch = 'J';//74
        char result = (char) (ch + 32); //106
        System.out.println(result);

        char ch2 = 'a';
        //char result2 = (char)(ch2 - 32);
        ch2 += -32;
        System.out.println(ch2);

        double d3 = 3.5;
        int i3 = 100;
        double sum3 = d3 + i3;
        System.out.println("sum3的值：" + sum3);
        System.out.println("sum3的整数部分的值：" + (int) sum3);

        double d4 = 1.7422;
        int i4 = 1000;
        int mul4 = (int) (d4 * i4);
        System.out.println("mul4的整数部分的值：" + mul4);
    }
}
