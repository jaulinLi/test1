package com.itheima.demo07Interface;

public interface A {
    public abstract void showA();

    public default void showB() {
        System.out.println("BBBB");
    }
}
