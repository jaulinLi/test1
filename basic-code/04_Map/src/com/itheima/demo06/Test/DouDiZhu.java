package com.itheima.demo06.Test;

import java.util.*;

/*
    斗地主综合案例:有序版本
    1.准备牌
    2.洗牌
    3.发牌
    4.排序
    5.看牌
 */
public class DouDiZhu {

    public static void main(String[] args) {
        HashMap<Integer, String> poker = new HashMap<>();
        ArrayList<Integer> pokerIndex = new ArrayList<>();

        List<String> colors = List.of("♥", "♠", "♣", "♦");
        List<String> numbers = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");

        int index = 0;
        poker.put(index,"大王");
        pokerIndex.add(index);
        index++;
        poker.put(index,"小王");
        pokerIndex.add(index);
        index++;

        for (String number : numbers) {
            for (String color : colors) {
                poker.put(index,color + number);
                pokerIndex.add(index);
                index++;
            }
        }
        System.out.println(poker);
//        System.out.println(pokerIndex);
        Collections.shuffle(pokerIndex);
//        System.out.println(pokerIndex);
        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();

        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer in = pokerIndex.get(i);
            if(in >=51){
                dipai.add(in);
            } else if(in % 3 == 0){
                player1.add(in);
            } else if(in % 3 == 1){
                player2.add(in);
            } else {
                player3.add(in);
            }
        }
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(dipai);

        lookPoker("张三",poker,player1);
        lookPoker("李四",poker,player2);
        lookPoker("王五",poker,player3);
        lookPoker("底牌",poker,dipai);
    }
    public static void lookPoker(String name,HashMap<Integer, String> poker,ArrayList<Integer> list){
            System.out.print(name + ": ");
            for (Integer key : list) {
                String value = poker.get(key);
                System.out.print(value + " ");
            }
            System.out.println();
        }
}
