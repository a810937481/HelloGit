package com.aop1;

import com.aop1.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop1 {

    public static void main(String[] args) {
        String xmlPath = "applicationContextAop1.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        userDao.addUser();
        userDao.deleteUser();
    }

}
