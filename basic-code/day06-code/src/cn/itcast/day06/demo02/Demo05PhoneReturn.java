package cn.itcast.day06.demo02;

public class Demo05PhoneReturn {

    public static void main(String[] args) {
        Phone two = getPhone();
        System.out.println(two.brand);
        System.out.println(two.color);
        System.out.println(two.price);
    }

    public static Phone getPhone() {
        Phone one = new Phone();
        one.price = 8888.0;
        one.color = "blue";
        one.brand = "苹果";
        return one;
    }

}

