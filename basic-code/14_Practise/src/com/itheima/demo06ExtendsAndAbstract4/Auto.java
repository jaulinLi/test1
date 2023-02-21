package com.itheima.demo06ExtendsAndAbstract4;

public class Auto {
    String brand;
    double length;
    double price;

    public Auto() {
    }

    public Auto(String brand, double length, double price) {
        this.brand = brand;
        this.length = length;
        this.price = price;
    }

    public void showMsg(){
        System.out.println("车型：SUV");
        System.out.println("    价格：" + getPrice());
        System.out.println("    车长：" + getLength());
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
