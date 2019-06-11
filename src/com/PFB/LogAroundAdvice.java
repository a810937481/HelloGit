package com.PFB;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogAroundAdvice implements MethodInterceptor {

    private Logger logger= LogManager.getLogger(LogAroundAdvice.class);
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long beginTime=System.currentTimeMillis();
        methodInvocation.proceed();
        long endTime=System.currentTimeMillis();
        String targetMethodName=methodInvocation.getMethod().getName();
        String logInfoText="环绕通知："+targetMethodName+"方法调用时间"+beginTime+"毫秒,"+"调用后时间"+endTime+"毫秒";
        logger.info(logInfoText);
        return null;
    }
}
