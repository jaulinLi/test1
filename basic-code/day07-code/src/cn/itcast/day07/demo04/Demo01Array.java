package cn.itcast.day07.demo04;

/*
题目：
定义一个数组，用来存储3个Person对象。

数组有一个缺点：一旦创建，程序运行期间长度不可以发生改变。
 */
public class Demo01Array {

    public static void main(String[] args) {
        Person[] array = new Person[3];

        Person one = new Person("张三",18);
        Person two = new Person("李四",28);
        Person three = new Person("王五",38);

        array[0] = one;
        array[1] = two;
        array[2] = three;

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);

        System.out.println("姓名:" + array[1].getName() + ",年龄：" + array[1].getAge());
    }

}
