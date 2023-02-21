package com.itheima.Stream;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01FileOutputStream {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\IdeaProjects\\basic-code\\14_Practise\\a.txt");
        fos.write('a');
    }
}
