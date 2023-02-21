package cn.itcast.day04.demo02;

public class Demo02Method {

    public static void main(String[] args) {
        printMethod();
    }

    public static void printMethod() {
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 10; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}

