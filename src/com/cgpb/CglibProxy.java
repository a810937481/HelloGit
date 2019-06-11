package com.cgpb;

import com.aspect.cgpbAspect;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    //代理方法
    public Object createProxy(Object target){
        //创建一个动态类对象
        Enhancer enhancer = new Enhancer();
        //确定需要增强的类，设置其父类
        enhancer.setSuperclass(target.getClass());
        //添加回调函数
        enhancer.setCallback((Callback) this);
        //返回创建的代理类
        return enhancer.create();

    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //创建切面类对象
        cgpbAspect cgpbAspect = new cgpbAspect();
        //前增强
        cgpbAspect.user_call();
        //目标方法执行
        Object object=methodProxy.invokeSuper(proxy,args);
        //后增强
        cgpbAspect.user_leave();
        return object;
    }

}
