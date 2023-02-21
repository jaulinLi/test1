package com.itheima.demo08Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo01DateText {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月DD日 HH:mm:ss");
        String format = sdf.format(date);
        System.out.println("转化后为：" + format);
    }
}
