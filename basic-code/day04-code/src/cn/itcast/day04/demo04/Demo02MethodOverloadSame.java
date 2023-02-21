package cn.itcast.day04.demo04;

/*
题目一：
比较两个数据是否相等，参数类型分别为：两个byte类型，两个short类型，两个int类型，两个long类型，并在main方法中进行测试

三要素：
返回值类型：boolean
方法名称：isSame
参数列表：如上
 */
public class Demo02MethodOverloadSame {

    public static void main(String[] args) {
        System.out.println(isSame((short)10,(short)20));
        System.out.println(isSame(10L,20L));
        System.out.println(isSame((byte) 20,(byte) 20));

    }

    public static boolean isSame(byte a, byte b) {
        System.out.println("两个byte参数的方法执行");
        boolean same;
        if (a == b) {
            same = true;
        } else {
            same = false;
        }
        return same;
    }

    public static boolean isSame(short a, short b){
        System.out.println("两个short参数的方法执行");
        boolean same=a==b?true:false;
        return same;
    }

    public static boolean isSame(int a, int b){
        System.out.println("两个int参数的方法执行");
        return a==b;
    }

    public static boolean isSame(long a, long b){
        System.out.println("两个long参数的方法执行");
        if (a==b){
            return true;
        }else{
            return false;
        }
    }
}

