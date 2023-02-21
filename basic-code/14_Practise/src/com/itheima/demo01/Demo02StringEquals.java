package com.itheima.demo01;

public class Demo02StringEquals {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "abc";
        String s3 = s1 + "c";
        System.out.println(s3 == s2); //false
        System.out.println(s3.equals(s2)); //true
    }
}
