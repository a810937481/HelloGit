package com.PFB;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class ThrowsLogAdvice implements ThrowsAdvice {
    private Logger logger= LogManager.getLogger(ThrowsLogAdvice.class);
    public void afterThrowing(Method method,Object[] args,Object target,Throwable exptionClass){
        String targetMethod=method.getName();
        String targetClassName=logger.getClass().getName();
        String logInfoText="异常通知：执行"+targetClassName+"类的"+targetMethod+"方法时发生异常";
        logger.info(logInfoText);
    }
}
