package com.itheima.demo06ExtendsAndAbstract2;

public class Duck extends Poultry {

    @Override
    public void showSymptom() {
        System.out.println("症状为：" + getSymptom());
    }

    public Duck() {
    }

    public Duck(String name, String symptom, int age, String illness) {
        super(name, symptom, age, illness); //Poutry内是私有成员变量，他为什么能继承
    }
}
