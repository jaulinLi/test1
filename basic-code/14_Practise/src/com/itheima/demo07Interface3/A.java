package com.itheima.demo07Interface3;

public interface A {

    public abstract void showA();

    private static void show10(String str) {
        for (int i = 0; i < 10; i++) {
            System.out.print(str);
        }
        System.out.println();
    }

    public static void showB10() {
        System.out.println("static BBBB"); //静态方法为什么不能在实现类重写，在测试类调用时为什么要用接口名调用
        show10("BBBB ");
    }

    public static void showC10() {
        System.out.println("static CCCC");
        show10("CCCC ");
    }
}
