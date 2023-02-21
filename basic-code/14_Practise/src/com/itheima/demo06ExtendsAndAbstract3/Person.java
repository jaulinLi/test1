package com.itheima.demo06ExtendsAndAbstract3;

public class Person {
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void showMsg1(){
        System.out.print(getName() + "老师，");
    }

    public void showMsg2(){
        System.out.print(getName() + "同学，");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
