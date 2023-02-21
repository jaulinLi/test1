package com.itheima.demo12Exception;


public class Demo01Test1 {
    public static void main(String[] args) throws StudentException {
        Student student = new Student();
        student.setScore(100);
        if (student.getScore() < 0) {
            throw new StudentException("分数无效");
        } else {
            System.out.println("成绩为：" + student.getScore());
        }
    }
}