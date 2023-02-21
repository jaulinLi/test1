package com.itheima.demo01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo04DateFormat {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf1.parse("2018-03-04");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
        String s = sdf2.format(d);
        System.out.println(s);
    }
}
