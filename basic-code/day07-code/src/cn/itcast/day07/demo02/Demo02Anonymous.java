package cn.itcast.day07.demo02;

import java.util.Scanner;

public class Demo02Anonymous {

    public static void main(String[] args) {

        //匿名对象作为方法参数
        // methodParam(new Scanner(System.in));

        //匿名对象作为返回值
        Scanner sc = methodReturn();
        int num = sc.nextInt();
        System.out.println("输入的是：" + num);

    }

    public static void methodParam(Scanner sc) {
        int num = sc.nextInt();
        System.out.println("输入的是：" + num);
    }

    public static Scanner methodReturn() {
        return new Scanner(System.in);
    }

}
