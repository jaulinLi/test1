package com.itheima.demo06ExtendsAndAbstract4;

public class SUV extends Auto {
    public SUV() {
    }

    public SUV(String brand, double length, double price) {
        super(brand, length, price);
    }

    public String SUVType() {
        double small = 4295;
        double middle = 5070;
        if (getLength() < small) {
            return "smallSUV";
        } else if (getLength() > middle) {
            return "bigSUV";
        } else {
            return "middleSUV";
        }
    }
}
