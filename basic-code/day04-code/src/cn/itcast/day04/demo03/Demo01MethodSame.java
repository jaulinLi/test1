package cn.itcast.day04.demo03;

/*
题目一：判断两个数字是否相同
三要素：
返回值类型：boolean
方法名称：isSame
参数列表：int a, int b
 */
public class Demo01MethodSame {
    public static void main(String[] args) {
        System.out.println(isSame(11,22));
        /*boolean num = isSame(10, 10);
        System.out.println("判断是" + num);*/
    }

    public static boolean isSame(int a, int b) {
        //第一种
        return a == b;

       /*第二种
        boolean same;
        if(a == b){
            same = true;
        }else{
            same = false;
        }
         return same;*/

       /*第三种
        boolean same = a == b ? true : false;
         return same;*/

        /*第四种
        boolean same = a == b;
        return same;*/
    }

}

