package com.itheima.demo10Overload;

public class Test3 {

    public static void main(String[] args) {
        showColor("green");
    }

    public static void showColor(String s) {
        switch (s) {
            case "red":
                System.out.println(s + "是红色");
                break;
            case "blue":
                System.out.println(s + "是蓝色");
                break;
            case "green":
                System.out.println(s + "是绿色");
                break;
            default:
                System.out.println("未知颜色");
                break;
        }
    }
}
