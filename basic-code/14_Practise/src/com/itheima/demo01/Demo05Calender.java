package com.itheima.demo01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Demo05Calender {

    public static void main(String[] args) throws ParseException {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        //Date date = sdf.parse("2018年2月14日");
        //System.out.println(date);
        Calendar ca = Calendar.getInstance();
        ca.set(2018, 2, 14);
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH);
        int date = ca.get(Calendar.DATE);
        char week = weekNumber(ca.get(Calendar.DAY_OF_WEEK) - 1);
        System.out.println(year + "年" + month + "月" + date + "日，星期" + week);
    }

    public static char weekNumber(int i) {
        //List<String> list = List.of("日", "一", "二", "三", "四", "五", "六");
        char[] chars = {'日', '一', '二', '三', '四', '五', '六'};
        return chars[i];
    }
}