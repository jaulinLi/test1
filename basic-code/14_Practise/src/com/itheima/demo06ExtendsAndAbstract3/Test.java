package com.itheima.demo06ExtendsAndAbstract3;

public class Test {

    public static void main(String[] args) {
        Teacher teacher = new Teacher("王小平",44,"Java课");
        Student student = new Student("李小乐",15,90);

        teacher.showMsg1();
        teacher.teach();
        student.showMsg2();
        student.cheek();
    }
}
