package cn.itcast.day06.demo03;

public class Demo04Student {

    public static void main(String[] args) {

        Student student = new Student();
        student.setName("李四");
        student.setAge(18);
        student.setMale(false);

        System.out.println("姓名："+ student.getName());
        System.out.println("年龄："+ student.getAge());
        System.out.println("是男人么？"+ student.isMale());

    }

}
