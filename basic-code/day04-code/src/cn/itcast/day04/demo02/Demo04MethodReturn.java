package cn.itcast.day04.demo02;

public class Demo04MethodReturn {
    public static void main(String[] args) {
        int num = getsum(20, 10);
        System.out.println("返回值是：" + num);
        System.out.println("=====================");
        printsum(4, 5);
    }

    //有返回值
    public static int getsum(int a, int b) {
        int result = a - b;
        return result;
    }

    //无返回值
    public static void printsum(int a, int b) {
        int result = a * b;
        System.out.println("结果是：" + result);
    }


}
