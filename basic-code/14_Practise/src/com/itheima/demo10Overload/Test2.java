package com.itheima.demo10Overload;

public class Test2 {

    public static void main(String[] args) {
        boolean b = doCheck(2);
        System.out.println(b);
        boolean b2 = doCheck(3);
        System.out.println(b2);
    }

    public static boolean doCheck(int iVar) {
        boolean flag = true;
        if (iVar % 2 == 0) {
            for (int i = 0; i <= 20; i++) {
                iVar -= i;
                flag = true;
            }
        } else {
            for (int i = 0; i <= 20; i++) {
                iVar += i;
                flag = false;
            }
        }
        System.out.println("num:" + iVar);
        return flag;
    }
}
