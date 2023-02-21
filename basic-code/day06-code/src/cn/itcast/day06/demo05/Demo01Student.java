package cn.itcast.day06.demo05;

public class Demo01Student {

    public static void main(String[] args) {

        Student stu1 = new Student();
        stu1.setName("张三");
        stu1.setAge(18);
        System.out.println("姓名是："+ stu1.getName() + ",年龄是:"+ stu1.getAge());
        System.out.println("======================");

        Student stu2 = new Student("李四",22);
        System.out.println("姓名是："+ stu2.getName() + ",年龄是:"+ stu2.getAge());
        stu2.setAge(24);
        System.out.println("姓名是："+ stu2.getName() + ",年龄是:"+ stu2.getAge());
    }

}
