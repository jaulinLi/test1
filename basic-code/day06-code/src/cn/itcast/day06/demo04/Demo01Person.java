package cn.itcast.day06.demo04;

public class Demo01Person {

    public static void main(String[] args) {
        Person person = new Person();
        // 设置我自己的名字
        person.name = "张老大";
        person.sayHello("张小小");

        System.out.println(person); // 地址值
    }

}
