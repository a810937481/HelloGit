package com.PFB;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterLogAdvice implements AfterReturningAdvice {
    private Logger target= LogManager.getLogger(AfterLogAdvice.class);
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        String targetMethod=method.getName();
        String targetClassName=target.getClass().getName();
        String logInfoText="后置通知："+targetClassName+"类的"+targetMethod+"方法已经执行";
        target.info(logInfoText);
    }
}
