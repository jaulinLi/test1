package cn.itcast.day04.demo04;

/*
功能类似，参数列表不一样，不需要记住那么多方法名称
方法的重载(Overload):多个方法名称一样，但参数列表不一样

方法重载与下列因素相关：
1.参数个数不同
2.参数类型不同
3.参数多类型的顺序不同
与下列因素无关：
1.参数的名称无关
2.方法的返回值类型无关

 */
public class Demo01MethodOverload {

    public static void main(String[] args) {
        System.out.println(sum(10, 20, 30));
        System.out.println(sum(10, 20, 30, 40));

    }
    public static int sum(double a, int b) {
        return (int) (a + b);
    }

    public static int sum(int a, double b) {
        return (int) (a + b);
    }

    public static int sum(int a, int b) {
        return a + b;
    }
//错误写法
   /* public static int sum(int x, int y) {
        return x + y;
    }*/
    public static int sum(double a, double b){
        return (int)(a+b);
    }

    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    public static int sum(int a, int b, int c, int d) {
        return a + b + c + d;
    }
}
