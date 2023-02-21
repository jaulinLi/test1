package cn.itcast.day06.demo04;

public class Demo02Student {

    public static void main(String[] args) {

        Student student1 = new Student();//无参构造
        System.out.println();
        System.out.println("================");

        Student student2 = new Student("张三",20);
        System.out.println("名字：" + student2.getName()+",年龄"+ student2.getAge());

        student2.setName("李四");
        student2.setAge(33);
        System.out.println("名字：" + student2.getName()+",年龄"+ student2.getAge());
    }

}
