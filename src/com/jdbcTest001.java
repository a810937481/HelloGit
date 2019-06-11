package com;

import com.jdbc001.Account;
import com.jdbc001.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class jdbcTest001 {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("jdbcaC.xml");
        AccountDao accountDao=(AccountDao) applicationContext.getBean("accountDao");

        Account account=new Account();
        account.setUsername("tom");
        account.setBalance(1000.00);
        int num = accountDao.addAccount(account);
        if(num>0){
            System.out.println("成功插入了"+num+"条数据");
        }else{
            System.out.println("插入操作执行失败！");
        }
    }
}
