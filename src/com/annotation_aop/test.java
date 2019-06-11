package com.annotation_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String xmlPath = "com/annotation_aop/apC.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserDAO userDAO = (UserDAO) applicationContext.getBean("userDao");
        User user1 = new User("a1","123");
        User user2 = new User("a2","456");
        User user3 = new User("a3","789");
        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userDAO.batchInsert(userList);
        List<User> userList2 = userDAO.getAllUser();
        Iterator<User> iterator = userList2.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getAccount());
        }
        User userget = userDAO.getUserById(3);
        System.out.println(userget.getId()+userget.getAccount()+userget.getPassword());
    }
}
