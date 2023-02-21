package com.itheima.demo06ExtendsAndAbstract4;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        SUV suv1 = new SUV("奥迪", 4660, 1000000);
        SUV suv2 = new SUV("奥迪", 4813, 1100000);
        SUV suv3 = new SUV("宝马", 4515, 1200000);
        SUV suv4 = new SUV("奔驰", 5170, 1050000);
        SUV suv5 = new SUV("奔驰", 4160, 1300000);

        ArrayList<SUV> list = new ArrayList<>();
        list.add(suv1);
        list.add(suv2);
        list.add(suv3);
        list.add(suv4);
        list.add(suv5);
        /*for (SUV suv : list) {
            if (suv.SUVType() == "middleSUV") {
                suv.showMsg();
            }
        }*/
        for (int i = 0; i < list.size(); i++) {
            SUV suv = list.get(i);
            if (suv.SUVType() == "middleSUV") {
                suv.showMsg();
            }
        }
    }
}
