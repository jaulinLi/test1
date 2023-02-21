package cn.itcast.day09.demo14;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User{

    public Member() {
    }

    public Member(String name, int money) {
        super(name, money);
    }

    public void receive(ArrayList <Integer> list){
        Random r = new Random();
        int num = r.nextInt(list.size());
        Integer delta = list.remove(num);

        //int index = new Random().nextInt(list.size());
        //Integer delta = list.remove(index);

        super.setMoney(getMoney() + num);

    }

}
