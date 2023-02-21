package cn.itcast.day04.demo02;
/*
定义方法的完整格式：
修饰符 返回值类型 方法名称(参数类型 参数名称,...){
    方法体
    return 返回值;
}

修饰符：现阶段固定写法public static
返回值类型：方法最终产生什么数据结果时什么类型
方法名称：方法的名字，规则和变量一样，小驼峰（ps:如果有多个用逗号分隔开）
方法体：方法需要做的事，若干代码
return：两个作用1.停止当前方法；2.将后面的返回值还给调用处
返回值：方法执行后最终产生的数据结果

注意：
return后面的返回值，必须和方法名称前面的返回值类型，保持对应

定义一个两个int数字相加的方法
三要素：
返回值类型：int
方法名称：sum
参数列表：int a,int b

方法的三中调用格式：
1.单独调用：方法名称(参数);
2.打印调用：System.out.println(方法名称(参数));
3.赋值调用：数据类型 变量名称 = 方法名称(参数);
*/

public class Demo02MethodDefine {

    public static void main(String[] args) {
        //单独调用
        sum(10, 20);
        System.out.println("===========================");

        //打印调用
        System.out.println(sum(15, 25));
        System.out.println("=========================");

        //赋值调用
        int num = sum(35, 45);
        num += 100;
        System.out.println("变量的值" + num);
    }

    public static int sum(int a, int b) {
        System.out.println("执行啦");
        int result = a + b;
        return result;
    }

}
