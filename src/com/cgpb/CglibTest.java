package com.cgpb;

public class CglibTest {
    public static void main(String[] args) {
        // 创建代理对象
        CglibProxy cglibProxy = new CglibProxy();
        CglibProxy cglibProxy1 = new CglibProxy();
        // 创建目标对象
        AnimalDao animalDao = new AnimalDao();
        CatDao catDao = new CatDao();
        // 获取增强后的目标对象
        AnimalDao animalDao1 = (AnimalDao)cglibProxy.createProxy(animalDao);
        CatDao catDao1=(CatDao)cglibProxy1.createProxy(catDao);
        // 执行方法
        animalDao1.eat();
        animalDao1.sleep();
        catDao1.eat();
        catDao1.sleep();
    }
}
