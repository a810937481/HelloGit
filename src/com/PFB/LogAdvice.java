package com.PFB;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class LogAdvice implements MethodBeforeAdvice {
    private Logger target= LogManager.getLogger(LogAdvice.class);
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String targetMethod=method.getName();
        String targetClassName=target.getClass().getName();
        String logInfoText="前置通知："+targetClassName+"类的"+targetMethod+"方法开始执行";
        target.info(logInfoText);
    }

}
