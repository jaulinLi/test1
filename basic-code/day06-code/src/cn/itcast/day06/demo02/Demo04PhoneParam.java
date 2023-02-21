package cn.itcast.day06.demo02;

public class Demo04PhoneParam {

    public static void main(String[] args) {
        Phone one = new Phone();
        one.brand = "苹果";
        one.color = "blue";
        one.price = 8888.0;

        Method(one);
    }
    public static void Method(Phone param){
        System.out.println(param.price);
        System.out.println(param.color);
        System.out.println(param.brand);
    }

}
