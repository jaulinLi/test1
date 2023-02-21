package com.itheima.demo10Overload;

public class Test4 {

    public static void main(String[] args) {
        getValue();

    }

    public static void getValue() {
        int[] array = {10, 20, 50};
        getMax(array);
    }

    public static void getMax(int[] ar) {
        int max = ar[0];
        for (int i = 1; i < ar.length; i++) {
            if (max < ar[i]) {
                max = ar[i];
            }
        }
        System.out.println("最大值是" + max);
    }

    public static void getMin(int[] ar) {
        int min = ar[0];
        for (int i = 1; i < ar.length; i++) {
            if (min > ar[i]) {
                min = ar[i];
            }
        }
        System.out.println("最小值是" + min);
    }
}
