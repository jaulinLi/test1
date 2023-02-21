package cn.itcast.day11.demo08;

import cn.itcast.day11.red.OpenMode;

import java.util.ArrayList;

public class NormalMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(int totalMoney, int totalCount) {
        ArrayList<Integer> redList = new ArrayList<>();

        int avg = totalMoney / totalCount;
        int mod = totalMoney % totalCount;

        for (int i = 0; i < totalCount-1; i++) {
            redList.add(avg);
        }
//        int last = avg + mod;
//        redList.add(last);
        redList.add(avg + mod);
        System.out.println(redList );

        return redList;
    }
}

