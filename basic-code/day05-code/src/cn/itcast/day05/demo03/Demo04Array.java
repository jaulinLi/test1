package cn.itcast.day05.demo03;

/*
遍历数组，说的就是对数组当中的每一个元素进行逐一、挨个儿处理。默认的处理方式就是打印输出。
 */
public class Demo04Array {

    public static void main(String[] args) {

        int[] array={10,20,30,40,50};
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
        System.out.println("============================");

        int len = array.length;
        for (int i = 0; i < array.length; i++) {
        System.out.println(array[i]);

        }

    }

}
