package com.itheima.demo04forwhileif;

public class Demo02Test2 {

    public static void main(String[] args) {
        double discount = 50;
        int totalPrice = 550;

        if(totalPrice >= 500){
            discount=0.5;
        } if(totalPrice>=400 && totalPrice <500){
            discount = 0.6;
        }  if (totalPrice >= 300 && totalPrice <400){
            discount = 0.7;
        }  if (totalPrice >=200 && totalPrice <300){
            discount = 0.8;
        }
        System.out.println("totalPrice：" + totalPrice);
        System.out.println("totalPrice的discount为：" + discount*totalPrice);
    }
}
