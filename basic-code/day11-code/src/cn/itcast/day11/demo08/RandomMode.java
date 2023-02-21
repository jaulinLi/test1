package cn.itcast.day11.demo08;

import cn.itcast.day11.red.OpenMode;

import java.util.ArrayList;
import java.util.Random;

public class RandomMode implements OpenMode{
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> redList = new ArrayList<>();

        Random r = new Random();
        int leftMoney = totalMoney;
        int leftCount = totalCount;

        for (int i = 0; i < totalCount-1; i++) {
            int money = r.nextInt(leftMoney / leftCount * 2) + 1;
            redList.add(money);
            leftMoney -= money;
            leftCount--;
        }

        redList.add(leftMoney);

        return redList;
    }
}
