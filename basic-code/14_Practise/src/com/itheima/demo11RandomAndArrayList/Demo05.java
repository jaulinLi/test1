package com.itheima.demo11RandomAndArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class Demo05 {

    public static void main(String[] args) {
        ArrayList<String> poker = new ArrayList<>();
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> nums = new ArrayList<>();
        ArrayList<String> owner = new ArrayList<>();

        poker.add("大王");
        poker.add("小王");
        Collections.addAll(colors, "♠", "♥", "♦", "♣");
        Collections.addAll(nums, "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
        for (String color : colors) {
            for (String num : nums) {
                poker.add(color + num);
            }
        }

        Collections.shuffle(poker);
        int in = 5;
        if (in <= poker.size()) {
            for (int i = 0; i < in; i++) {
                owner.add(poker.get(i));
            }
            System.out.println("随机" + in + "张牌：");
            System.out.println(owner);

        } else if (in > poker.size()) {
            System.out.println("随机" + in + "张牌：");
            System.out.println("超越范围，无法获取");
        }
    }
}
