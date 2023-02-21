package com.itheima.Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo06Copy {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\a.png");
        FileOutputStream fos = new FileOutputStream("D:\\a.png");
        int len = 0;
        while ((len = fis.read()) != -1) {
            fos.write(len);
        }
        fos.close();
        fis.close();
    }
}
