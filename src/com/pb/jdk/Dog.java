package com.pb.jdk;

public class Dog implements AnimalDao {
    @Override
    public void eat() {
        System.out.println("狗狗在吃好吃的");
    }

    @Override
    public void sleep() {
        System.out.println("狗狗在睡觉");
    }
}
