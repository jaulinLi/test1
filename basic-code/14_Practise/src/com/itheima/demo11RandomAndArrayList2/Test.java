package com.itheima.demo11RandomAndArrayList2;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> list = new ArrayList<>();

        while (true) {
            System.out.println("1.录入信息 0.退出");
            int num = sc.nextInt();
            if (num == 1) {
                System.out.println("请输入姓名：");
                String s = sc.next();
                System.out.println("请输入年龄：");
                int i = sc.nextInt();

                Person person = new Person(s, i);
                list.add(person);
            }
            if (num == 0) {
                System.out.println("录入完毕");
                for (Person p : list) {
                    System.out.println("学生姓名=" + p.getName() + ",年龄=" + p.getAge());
                }
                break;
            }
        }
    }
}
