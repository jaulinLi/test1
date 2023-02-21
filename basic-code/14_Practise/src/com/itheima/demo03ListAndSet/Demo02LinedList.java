package com.itheima.demo03ListAndSet;

import java.util.Collections;
import java.util.LinkedList;

public class Demo02LinedList {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Collections.addAll(list,100,200,300,400,500);

        list.addFirst(50);
        System.out.println(list);

        list.addLast(600);
        System.out.println(list);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        Integer i1 = list.removeFirst();
        System.out.println(i1);
        System.out.println(list);

        Integer i2 = list.removeLast();
        System.out.println(i2);
        System.out.println(list);

        list.push(88);
        System.out.println(list);

        Integer i3 = list.pop();
        System.out.println(i3);
        System.out.println(list);

        list.clear();
        System.out.println(list);
    }
}
