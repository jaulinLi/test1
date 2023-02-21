package com.itheima.Stream;

import java.io.FileWriter;
import java.io.IOException;

public class Demo07FileWrite {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("14_Practise\\Info.text", true);
        try {
            fw.write("张三");
            fw.write("\r\n");
            fw.write("李四");
            fw.write("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
            fw.write("886");
            fw.close();
        }
    }
}