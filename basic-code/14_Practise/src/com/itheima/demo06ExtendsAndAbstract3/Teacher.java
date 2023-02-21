package com.itheima.demo06ExtendsAndAbstract3;

public class Teacher extends Person {
    String subject;

    public Teacher() {
    }

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void teach(){
        System.out.println("讲授"+getSubject());
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
