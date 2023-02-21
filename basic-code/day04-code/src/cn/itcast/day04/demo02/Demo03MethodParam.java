package cn.itcast.day04.demo02;
/*
1.有参数：小括号中有内容才能完成任务
2.无参数：小括号中留空

*/
public class Demo03MethodParam {
    public static void main(String[] args) {
        method1(15,3);
        System.out.println("====================");
        method2();
    }
    //有参数 两个数相除
    public static void method1 (int a,int b){
        int result = a/b;
        System.out.println("结果是："+result);
        }

     //打印固定10次文本
     public static void method2(){
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello,World!");
            }

        }

}
