package com.pb.jdk;

public class Cat implements AnimalDao{
    @Override
    public void eat() {
        System.out.println("猫猫在吃好吃的");
    }

    @Override
    public void sleep() {
        System.out.println("猫猫在睡觉");
    }
}
