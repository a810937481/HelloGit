package com.an;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationIocBeanTest {

    public static void main(String[] args) {
        AbstractApplicationContext ac=new ClassPathXmlApplicationContext("com/an/beans.xml");
        AnnotationIoCBean annotationioCBean=(AnnotationIoCBean)ac.getBean("annotationIocBean");
        annotationioCBean.execute();
    }

}
