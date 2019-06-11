package com.pb.jdk;

public class JdkTest {

    public static void main(String[] args) {
        //创建代理对象
        AnimalProxy CatProxy=new AnimalProxy();
        AnimalProxy DogProxy=new AnimalProxy();
        //创建目标对象
        AnimalDao cat=new Cat();
        AnimalDao dog=new Dog();
        //从代理对象中获取增强后的目标对象
        AnimalDao cat1=(AnimalDao)CatProxy.createProxy(cat);
        AnimalDao dog1=(AnimalDao)DogProxy.createProxy(dog);
        //执行方法
        cat1.eat();
        System.out.println("*********************");
        cat1.sleep();
        System.out.println("*********************");
        dog1.eat();
        System.out.println("*********************");
        dog1.sleep();
        System.out.println("*********************");
    }

}
