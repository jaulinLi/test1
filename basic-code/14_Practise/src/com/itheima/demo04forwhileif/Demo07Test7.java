package com.itheima.demo04forwhileif;

public class Demo07Test7 {

    public static void main(String[] args) {
        boolean bVar = false;
        boolean bVar1 = true;
        int count = 8;

        do {
            System.out.println("Hello,Java! " + count);
            if (count >= 7) {
                bVar1 = false;
                count--;
            } else {
                count += 3;
            }
        }
        while (bVar == bVar1 && count < 9);
    }
}
