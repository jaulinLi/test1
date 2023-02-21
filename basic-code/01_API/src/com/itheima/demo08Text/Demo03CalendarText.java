package com.itheima.demo08Text;

import java.util.Calendar;

public class Demo03CalendarText {

    public static void main(String[] args) {

        Calendar ca = Calendar.getInstance();
        ca.set(2018,2,14);
        char week = getWeek(ca.get(Calendar.DAY_OF_WEEK)-1);
        System.out.println(week);

    }

    public static char getWeek(int i){
        char[] ca = {'日','一','二','三','四','五','六',};
        return ca[i];
    }
}
