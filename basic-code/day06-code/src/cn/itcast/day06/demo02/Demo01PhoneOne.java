package cn.itcast.day06.demo02;

public class Demo01PhoneOne {

    public static void main(String[] args) {

        Phone pho = new Phone();

        //成员变量
        pho.brand = "Apple";
        pho.color = "White";
        pho.price = 5500.50;
        System.out.println(pho.brand);
        System.out.println(pho.color);
        System.out.println(pho.price);
        System.out.println("==============================");

        //成员方法
        pho.call("张三");
        pho.sendMessage();

    }
}
