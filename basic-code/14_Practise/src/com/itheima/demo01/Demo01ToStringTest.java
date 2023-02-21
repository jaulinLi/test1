package com.itheima.demo01;

public class Demo01ToStringTest {
    static int i = 1;

    public static void main(String args[]) {
        System.out.println("love " + new Demo01ToStringTest());
        Demo01ToStringTest a = new Demo01ToStringTest();
        a.i++;
        System.out.println("me " + a.i);
    }

    public String toString() {
        System.out.print("I ");
        return "java ";
    }
}
