package com.itheima.demo04.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
    斗地主综合案例:
        1.准备牌
        2.洗牌
        3.发牌
        4.看牌
 */
public class DouDiZhu {

    public static void main(String[] args) {
        ArrayList<String> poker = new ArrayList<>();
        poker.add("大王");
        poker.add("小王");

        Collection<String> coll1 = new ArrayList<>();
        coll1.add("♠");
        coll1.add("♥");
        coll1.add("♣");
        coll1.add("♦");
//        System.out.println(coll1);

        Collection<String> coll2 = new ArrayList<>();
        coll2.add("2");
        coll2.add("3");
        coll2.add("4");
        coll2.add("5");
        coll2.add("6");
        coll2.add("7");
        coll2.add("8");
        coll2.add("9");
        coll2.add("10");
        coll2.add("J");
        coll2.add("Q");
        coll2.add("K");
        coll2.add("A");
//        System.out.println(coll2);

        for (String color : coll1) {
            for (String number : coll2) {
//                System.out.println(color + number);
                poker.add(color+number);
            }
        }
        Collections.shuffle(poker);
//        System.out.println(poker);

        Collection<String> player1 = new ArrayList<>();
        Collection<String> player2 = new ArrayList<>();
        Collection<String> player3 = new ArrayList<>();
        Collection<String> dipai = new ArrayList<>();

        for (int i = 0; i < poker.size(); i++) {
            String str = poker.get(i);
            if(i >=51){
                dipai.add(str);
            } else if(i%3==0){
                player1.add(str);
            } else if(i % 3 == 1) {
                player2.add(str);
            } else {
                player3.add(str);
            }
        }
        System.out.println("玩家一的牌是：" +player1);
        System.out.println("玩家二的牌是：" +player2);
        System.out.println("玩家三的牌是：" +player3);
        System.out.println("底牌是：" + dipai);
    }
}