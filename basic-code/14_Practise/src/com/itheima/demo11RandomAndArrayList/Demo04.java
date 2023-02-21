package com.itheima.demo11RandomAndArrayList;

import java.util.ArrayList;
import java.util.Random;

public class Demo04 {

    public static void main(String[] args) {
        ArrayList<Integer> list = getScoreList();
        int[] array = countScore(list);
        printCount(array);

    }

    public static ArrayList<Integer> getScoreList() {
        Random r = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            int num = r.nextInt(101);
            list.add(num);
        }
        return list;
    }

    public static int[] countScore(ArrayList<Integer> al) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;

        for (Integer score : al) {
            if (score <= 100 && score >= 80) {
                count1++;
            } else if (score <= 79 && score >= 60) {
                count2++;
            } else if (score <= 59 && score >= 40) {
                count3++;
            } else {
                count4++;
            }
        }
        int[] array = {count1, count2, count3, count4};
        return array;
    }

    public static void printCount(int[] ar) {
        System.out.println("100分--80分：" + ar[0] + "人");
        System.out.println("79分--60分：" + ar[1] + "人");
        System.out.println("59分--40分：" + ar[2] + "人");
        System.out.println("39分--0分：" + ar[3] + "人");
    }
}
