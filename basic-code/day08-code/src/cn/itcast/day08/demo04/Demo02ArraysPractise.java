package cn.itcast.day08.demo04;


import java.util.Arrays;
import java.util.Random;


/*
题目：
请使用Arrays相关的API，将一个随机字符串中的所有字符升序排列，并倒序打印。
 */
public class Demo02ArraysPractise{

    public static void main(String[] args) {

        Random r = new Random();
        int[] array = new int[10];

        System.out.println("随机生成的数是：" );
        for (int i = 0; i < 10; i++) {
            int num = r.nextInt(10);
            array[i] = num;
            System.out.println(num);
        }

        Arrays.sort(array);
        System.out.println("倒序是：");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }
}
