package cn.itcast.day06.demo01;

import java.util.Arrays;

/*
面向过程：当需要实现一个功能的时候，每一个具体的步骤都要亲力亲为，详细处理每一个细节。
面向对象：当需要实现一个功能的时候，不关心具体的步骤，而是找一个已经具有该功能的人，来帮我做事儿。
 */
public class Demo01PrintArray {
    public static void main(String[] args) {

        int[] array = {10, 20, 30, 40, 50};

        //面向过程：
        //要求打印格式：[10,20,30,40,50]
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) { //如果是最后一个元素
                System.out.println(array[i] + "]");
            } else { //若果不是最后一个元素
                System.out.print(array[i] + ",");
            }
        }
        System.out.println("===================================");

        //面向对象：
        System.out.println(Arrays.toString(array));
    }

}
