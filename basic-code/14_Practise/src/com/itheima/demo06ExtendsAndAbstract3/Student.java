package com.itheima.demo06ExtendsAndAbstract3;

public class Student extends Person {
    int score;

    public Student() {
    }

    public Student(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }

    public void cheek(){
        System.out.println("考试得了：" + getScore() + "分");
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
