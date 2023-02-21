package com.itheima.demo09Map;

import java.util.HashMap;
import java.util.Map;

public class Demo04Map4 {

    public static void main(String[] args) {
        String[] array1 = {"黑龙江省", "浙江省", "江西省", "广东省", "福建省"};
        String[] array2 = {"哈尔滨", "杭州", "南昌", "广州", "福州"};


        Map<String, String> map = new HashMap<>();
        for (int i1 = 0; i1 < array1.length; i1++) {
            for (int i2 = 0; i2 < array2.length; i2++) {
                //if (i1 == i2)
                    map.put(array1[i1], array2[i2]);
            }
        }
        System.out.println(map);
    }
}
