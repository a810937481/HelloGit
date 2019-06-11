package com.aop1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class TimerAspect {

    @Pointcut("execution(* com.aop1.dao.*.*(..))")
    public void p(){}

    @Around("TimerAspect.p()")
    public void tA(ProceedingJoinPoint joinPoint) throws Throwable{
        Long time1=System.currentTimeMillis();
        joinPoint.proceed();
        Long time2=System.currentTimeMillis();
        Long runTime=time2-time1;
        String targetMethod=joinPoint.getSignature().getName();
        String targetClassName=joinPoint.getClass().getName();
        Date now = new Date(time2);
        MonitorTime monitorTime=new MonitorTime();
        monitorTime.setMethodName(targetMethod);
        monitorTime.setClassName(targetClassName);
        monitorTime.setLogTime(now);
        monitorTime.setComsumeTime(runTime);
        MonitorUtils.report(monitorTime);
    }

    @AfterThrowing(value = "TimerAspect.p()",throwing = "e")
    public void tA(JoinPoint joinPoint,Throwable e){
        String targetMethod1=joinPoint.getSignature().getName();
        String targetClassName1=joinPoint.getTarget().getClass().getName();
        Long now=System.currentTimeMillis();
        Date date=new Date(now);
        String targetMessage=e.getMessage();
        ExceptionInfo exceptionInfo=new ExceptionInfo();
        exceptionInfo.setMethodName(targetMethod1);
        exceptionInfo.setClassName(targetClassName1);
        exceptionInfo.setLogTime(date);
        exceptionInfo.setMessage(targetMessage);
        ExceptionReportUtils.report(exceptionInfo);
    }

}
