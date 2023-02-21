package com.itheima.Stream;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo04FileInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("14_Practise\\a.txt");
        int len = 0;
        while ((len = fis.read()) != -1) {
            System.out.print(len);
        }
        fis.close();
    }
}
