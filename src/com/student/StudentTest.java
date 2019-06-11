package com.student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {
    public static void main(String[] args) {

        String xmlPath="com/student/Student.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        System.out.println(applicationContext.getBean("student1"));
        System.out.println(applicationContext.getBean("student2"));

    }
}
