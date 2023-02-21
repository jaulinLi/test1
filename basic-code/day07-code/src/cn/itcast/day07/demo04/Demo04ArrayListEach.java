package cn.itcast.day07.demo04;

import java.util.ArrayList;

public class Demo04ArrayListEach {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

}
