package com.itheima.demo11RandomAndArrayList;

import java.util.Random;

public class Demo01Random {

    public static void main(String[] args) {
        char[] array = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'G', 'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        Random ra = new Random();

        for (int i2 = 0; i2 < 10; i2++) {
            System.out.print("随机验证码：");

            for (int i = 0; i < 6; i++) {
                int num = ra.nextInt(array.length);
                System.out.print(array[num]);
            }
            System.out.println();
        }
    }
}
