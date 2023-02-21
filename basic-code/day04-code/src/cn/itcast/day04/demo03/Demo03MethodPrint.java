package cn.itcast.day04.demo03;
/*
题目三：定义一个方法，用来打印指定次数的HelloWorld

三要素
返回值类型：没有结果要告诉调用处，无return
方法名称：printCount
参数列表：int
 */
public class Demo03MethodPrint {
    public static void main(String[] args) {
        printCount(5);

    }

    public static void printCount(int num) {
        for (int i = 1; i <= num; i++) {
            System.out.println("Hello,World" + i);
        }
    }
}
