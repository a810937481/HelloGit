package com.PFB;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService=(UserService)context.getBean("userProxy");
        userService.addUser("李四","123456");
        userService.delUser(1);
    }
}
