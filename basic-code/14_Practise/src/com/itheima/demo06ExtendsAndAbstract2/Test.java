package com.itheima.demo06ExtendsAndAbstract2;

public class Test {

    public static void main(String[] args) {
        Duck duck = new Duck("鸭子", "发烧", 2, "感冒");
        duck.showMsg();
        duck.showSymptom();
    }
}
