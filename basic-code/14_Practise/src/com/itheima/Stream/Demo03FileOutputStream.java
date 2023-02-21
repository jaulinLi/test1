package com.itheima.Stream;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo03FileOutputStream {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("14_Practise\\c.txt", true);
        for (int i = 0; i < 5; i++) {
            fos.write("I love Jaulin".getBytes());
            fos.write("\r\n".getBytes());
        }
        fos.close();
    }
}
