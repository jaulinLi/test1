package cn.itcast.day05.demo03;

public class Demo05ArrayMax {

    public static void main(String[] args) {

        int[] array = {100000, 5, 78, 400, 133, 56};
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }

        }
        System.out.println("最大值是:" + max);
    }

}
