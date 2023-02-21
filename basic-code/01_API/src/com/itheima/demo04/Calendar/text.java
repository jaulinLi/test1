package com.itheima.demo04.Calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class text {

    public static void main(String[] args) throws ParseException {

        Date date = new Date(33333L);
        System.out.println(date);

        SimpleDateFormat slf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String format = slf.format(date);
        System.out.println(format);

        String str= "2022年08月15日 16:08:22";
        Date parse = slf.parse(str);
    }
}
