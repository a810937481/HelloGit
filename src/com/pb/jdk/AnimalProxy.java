package com.pb.jdk;

import com.pb.aspect.pbAscpect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AnimalProxy implements InvocationHandler {

    //声明目标类接口
    private AnimalDao animalDao;
        //创建代理方法
        public Object createProxy(AnimalDao animalDao){
            this.animalDao=animalDao;
            //1.类加载器
            ClassLoader classLoader= AnimalProxy.class.getClassLoader();
            //2.被代理对象实现的所有接口
            Class[] clazz=animalDao.getClass().getInterfaces();
            //3.使用代理类
            return Proxy.newProxyInstance(classLoader,clazz,this);
        }

    /*笔记：
     * 所有动态代理类的方法调用，都会交由invoke()方法去处理
     * proxy 被代理后的对象
     * method 将要被执行的方法信息（反射）
     * args 执行方法时需要的参数
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //声明切面
        pbAscpect pbascpect=new pbAscpect();
        //前增强
        pbascpect.master_call();
        //在目标类上调用方法，并传入参数
        Object obj=method.invoke(animalDao,args);
        //后增强
        pbascpect.master_leave();
        return obj;
    }
}
