package com.itheima.Stream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Demo08Properties {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("14_Practise\\score.text");
        fw.write("zhangsan = 90");
        fw.write("\r\n");
        fw.write("lisi = 80");
        fw.write("\r\n");
        fw.write("wangwu = 85");

        Properties pro = new Properties();
        pro.load(new FileReader("14_Practise\\score.text"));
        Set<String> set = pro.stringPropertyNames();
        for (String key : set) {
            if (key =="lisi"){
                String str = pro.getProperty(key);
                str = "100";
            }
        }
        pro.store(fw," ");

    }
}
