package com.itheima.Stream;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo05FileInputStream {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("14_Practise\\b.txt");
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        fis.close();
    }
}
