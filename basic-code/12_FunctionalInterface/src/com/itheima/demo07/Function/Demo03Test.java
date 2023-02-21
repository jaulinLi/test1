package com.itheima.demo07.Function;

import java.util.function.Function;

/*
    练习：自定义函数模型拼接
    题目
    请使用Function进行函数模型的拼接，按照顺序需要执行的多个函数操作为：
        String str = "赵丽颖,20";

    分析:
    1. 将字符串截取数字年龄部分，得到字符串；
        Function<String,String> "赵丽颖,20"->"20"
    2. 将上一步的字符串转换成为int类型的数字；
        Function<String,Integer> "20"->20
    3. 将上一步的int数字累加100，得到结果int数字。
        Function<Integer,Integer> 20->120
 */
public class Demo03Test {

    public static void change(String s, Function<String, String> fun1,
                              Function<String, Integer> fun2, Function<Integer, Integer> fun3) {
        Integer i = fun1.andThen(fun2).andThen(fun3).apply(s);
        System.out.println(i);
    }

    public static void main(String[] args) {
        String str = "赵丽颖,20";
        change(str, (String s) -> {
            return s.split(",")[1];
        }, (String s) -> {
            return Integer.parseInt(s);
        }, (Integer i) -> {
            return i + 100;
        });
    }
}
