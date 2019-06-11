package com.annotation_aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice {

    private final Logger logger = LogManager.getLogger(UserDAOImpl.class);

    //切点，对DAOImpl的所有方法
    @Pointcut("execution(* com.annotation_aop.UserDAOImpl.*(..))")
    public void pc(){ }

    //前置增强，并指定切点
    @Before("MyAdvice.pc()")
    public void before(){
        logger.info("----开始操作----");
    }

    //后置增强，并指定切点，出现异常不会调用
    @AfterReturning("execution(* com.annotation_aop.UserDAOImpl.*(..))")
    public void afterReturning(){
        logger.info("----操作完成----");
    }

    //异常增强
    @AfterThrowing("execution(* com.annotation_aop.UserDAOImpl.*(..))")
    public void afterException(){
        logger.error("出现异常");
    }

}
