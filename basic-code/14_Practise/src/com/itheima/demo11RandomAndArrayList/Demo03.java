package com.itheima.demo11RandomAndArrayList;

import java.util.ArrayList;
import java.util.Random;

public class Demo03 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            int num = r.nextInt(10) + 1;
            list.add(num);
        }
        System.out.println(list);
        int result1 = printCount(1, list);
        int result2 = printCount(2, list);
        int result3 = printCount(3, list);
        int result4 = printCount(4, list);
        int result5 = printCount(5, list);
        int result6 = printCount(6, list);
        int result7 = printCount(7, list);
        int result8 = printCount(8, list);
        int result9 = printCount(9, list);
        int result10 = printCount(10, list);
        System.out.println("数字1次数" + result1);
        System.out.println("数字2次数" + result2);
        System.out.println("数字3次数" + result3);
        System.out.println("数字4次数" + result4);
        System.out.println("数字5次数" + result5);
        System.out.println("数字6次数" + result6);
        System.out.println("数字7次数" + result7);
        System.out.println("数字8次数" + result8);
        System.out.println("数字9次数" + result9);
        System.out.println("数字10次数" + result10);

    }

    public static int printCount(int num, ArrayList<Integer> al) {
        int count = 0;
        for (Integer i : al) {
            if (i == num) {
                count++;
            }
        }
        return count;
    }
}
