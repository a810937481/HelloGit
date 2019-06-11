package com.aspect.xml;

import com.cgpb.CatDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestXmlAspectj {
    public static void main(String[] args) {
        String xmlPath = "com/aspect/xml/applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        CatDao catDao = (CatDao) applicationContext.getBean("catDao");
        catDao.eat();
        catDao.sleep();
    }
}
