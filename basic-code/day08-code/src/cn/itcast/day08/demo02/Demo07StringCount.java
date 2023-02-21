package cn.itcast.day08.demo02;

import java.util.Scanner;

/*
题目：
键盘输入一个字符串，并且统计其中各种字符出现的次数。
种类有：大写字母、小写字母、数字、其他

思路：
1. 既然用到键盘输入，肯定是Scanner
2. 键盘输入的是字符串，那么：String str = sc.next();
3. 定义四个变量，分别代表四种字符各自的出现次数。
4. 需要对字符串一个字、一个字检查，String-->char[]，方法就是toCharArray()
5. 遍历char[]字符数组，对当前字符的种类进行判断，并且用四个变量进行++动作。
6. 打印输出四个变量，分别代表四种字符出现次数。
 */
public class Demo07StringCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：" );
        String str = sc.next();

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if('A' <=ch && ch <= 'Z'){
                num1++;
            }else if ('a' <= ch && ch <= 'z'){
                num2++;
            } else if ('0' <=ch && ch <= '9'){
                num3++;
            }else{
                num4++;
            }
        }

        System.out.println("大写字母有" + num1);
        System.out.println("小写字母有" + num2);
        System.out.println("数字有" + num3);
        System.out.println("其他有" + num4);
    }

}
