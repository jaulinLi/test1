package com.itheima.demo07Interface4;

public class Test {

    public static void main(String[] args) {
        Star star = new Star();
        star.shine();
        System.out.println("=======================");

        Universe universe = new Sun();
        universe.doAnything();

        Sun sun = (Sun)universe;
        sun.sunDo(); //为什么要用多态，感觉很麻烦
    }
}
