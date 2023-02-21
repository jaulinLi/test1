package cn.itcast.day09.demo14;

import java.util.ArrayList;

// 群主的类
public class Manager extends User {

    public Manager() {
    }

    public Manager(String name, int money) {
        super(name, money);
    }


    public ArrayList<Integer> send(int totalmoneg, int count) {
        ArrayList<Integer> redList = new ArrayList<>();

        int leftmoney = super.getMoney();
        if (totalmoneg > leftmoney) {
            System.out.println("余额不足");
            return redList;
        }

        super.setMoney(leftmoney - totalmoneg);

        int avg = totalmoneg / count;
        int mod = totalmoneg % count;

        for (int i = 0; i < count - 1; i++) {
            redList.add(avg);
        }
        int last = avg + mod;
        redList.add(last);

        return redList;
    }
}
