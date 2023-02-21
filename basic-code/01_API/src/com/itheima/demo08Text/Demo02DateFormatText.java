package com.itheima.demo08Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo02DateFormatText {

    public static void main(String[] args) throws ParseException {


        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-DD");
        Date date = sdf1.parse("2018-03-04");

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月DD日");
        String str2 = sdf2.format(date);
        System.out.println(str2);

    }
}
