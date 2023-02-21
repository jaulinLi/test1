package com.itheima.Stream;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo02FileOutputStream {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("14_Practise\\b.txt");
        fos.write("I love Jaulin".getBytes());

        fos.close();
    }
}
