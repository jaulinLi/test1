package cn.itcast.day05.demo03;

public class Demo06ArrayMin {

    public static void main(String[] args) {
        int[] array = {11, 56, 58, 99, -8, 444, 6};

        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }

        }
        System.out.println("最小值是:" + min);
    }

}
