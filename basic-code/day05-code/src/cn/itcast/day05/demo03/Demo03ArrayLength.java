package cn.itcast.day05.demo03;

/*
如何获取数组的长度，格式：
数组名称.length

这将会得到一个int数字，代表数组的长度。

数组一旦创建，程序运行期间，长度不可改变。
 */
public class Demo03ArrayLength {

    public static void main(String[] args) {

        int[] array = {1,2,3,4,56,456,45858,55,88,522,8,55,55,66,98,8552,687,555};
        int len=array.length;//可省
        System.out.println("长度是："+array.length);
    }


}
