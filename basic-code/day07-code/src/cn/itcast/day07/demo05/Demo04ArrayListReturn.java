package cn.itcast.day07.demo05;

import java.util.ArrayList;
import java.util.Random;

/*
题目：
用一个大集合存入20个随机数字，然后筛选其中的偶数元素，放到小集合当中。
要求使用自定义的方法来实现筛选。

分析：
1. 需要创建一个大集合，用来存储int数字：<Integer>
2. 随机数字就用Random nextInt
3. 循环20次，把随机数字放入大集合：for循环、add方法
4. 定义一个方法，用来进行筛选。
筛选：根据大集合，筛选符合要求的元素，得到小集合。
三要素
返回值类型：ArrayList小集合（里面元素个数不确定）
方法名称：getSmallList
参数列表：ArrayList大集合（装着20个随机数字）
5. 判断（if）是偶数：num % 2 == 0
6. 如果是偶数，就放到小集合当中，否则不放。
 */
public class Demo04ArrayListReturn {

    public static void main(String[] args) {
        ArrayList<Integer> bigList = new ArrayList<>(); //定义一个大方法

        Random r = new Random(); //随机生成数字
        for (int i = 0; i < 20; i++) { //循环20次，生成20个随机数字
            int num = r.nextInt(100);
            bigList.add(num);
        }
        //调用
        ArrayList<Integer> smallList = getSmallList(bigList);

        System.out.println("偶数总共有多少个：" + smallList.size());
        //遍历
        for (int i = 0; i < smallList.size(); i++) {
        System.out.println(smallList.get(i));
        }
    }

    //定义一个方法，接受大集合数据，返回小集合数据
    public static ArrayList<Integer> getSmallList(ArrayList<Integer> bigList){
        //创建一个小集合用来装偶数
        ArrayList<Integer> smallList = new ArrayList<>();
        //遍历大集合数据
        for (int i = 0; i < bigList.size(); i++) {
           int num = bigList.get(i);
           //判断是否偶数，传入小集合
           if(num % 2 == 0 ){
               smallList.add(num);
           }
        }
        return smallList;
    }

}
