package com.itheima.demo04forwhileif;

public class Demo03Test3 {

    public static void main(String[] args) {
        for (int r = 10; r > 0;) {
            int c = r;
            while (c >= 0){
                System.out.print(c+" ");
                c = c -2;
            }
            r = r/c;
            //r = c;
            System.out.println(r);
        }
    }
}