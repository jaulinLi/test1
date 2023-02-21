package com.itheima.demo09Map2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        Map<Car, Double> map = new HashMap<>();
        map.put(new Car("宝马", "red"), 100.5);
        map.put(new Car("奔驰", "red"), 200.0);
        map.put(new Car("奥迪", "red"), 200.5);
        map.put(new Car("林肯", "red"), 300.5);
        map.put(new Car("五菱", "red"), 400.0);
        System.out.println(map);

        /*Set<Car> cars = map.keySet();
        for (Car key : cars) {
            Double value = map.get(key);
            System.out.println(key +"-->"+ value);
        }*/

        Set<Map.Entry<Car, Double>> set = map.entrySet();
        for (Map.Entry<Car, Double> entry : set) {
            Car key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + "-->" + value);
        }
    }
}
