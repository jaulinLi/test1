package com.itheima.demo10Overload;

import java.util.ArrayList;

public class Test6 {

    public static void main(String[] args) {
        double[] array = {10.1, 10.2, 10.3, 10.4, 10.5};
        ArrayList<Integer> al = round(array);
        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < al.size(); i1++) {
            }
            System.out.println(array[i] + "-->" + al.get(i));
        }
    }

    public static ArrayList<Integer> round(double[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (double dd : array) {
            list.add((int) (dd += 0.5));
        }
        return list;
    }
}