package com.itheima.demo10Overload;

public class Test5 {

    public static void main(String[] args) {
        printX();

    }

    public static void printX(){
        for (int i = 0; i < 10; i++) {
            System.out.print("O");
            for (int i1 = 0; i1 < 10; i1++) {
                System.out.print("*");
            }
            System.out.println("O");
        }
    }
}
