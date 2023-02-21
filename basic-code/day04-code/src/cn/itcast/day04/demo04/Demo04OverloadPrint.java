package cn.itcast.day04.demo04;
//byte short int long float double boolean char
//string
public class Demo04OverloadPrint {

    public static void main(String[] args) {
        myPrint('2');
        myPrint("ccc");

    }

    public static void myPrint(byte num){
        System.out.println(num);
    }

    public static void myPrint(short num){
        System.out.println(num);
    }

    public static void myPrint(int num){
        System.out.println(num);
    }

    public static void myPrint(long num){
        System.out.println(num);
    }

    public static void myPrint(char zifu){
        System.out.println(zifu);
    }

    public static void myPrint(boolean is){
        System.out.println(is);
    }

    public static void myPrint(String str){
        System.out.println(str);
    }
}

