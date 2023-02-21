package com.itheima.demo07Interface4;

public class Sun extends Star implements Universe {

    @Override
    public void doAnything() {
        System.out.println("sun:太阳吸引着九大行星旋转");
    }

    public void sunDo(){
        System.out.println("sun:光照八分钟，到达地球");
    }
}
