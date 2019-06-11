package com.JUnit5StudyUserLogin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)//指定单元测试的运行环境
@ContextConfiguration(locations = {"userbeans.xml"})//指定配置文件路径
class UserLoginTest {

    private User user;
    private UserLogin userLogin;

    @Test
    void userLogin() throws Exception{
        boolean result=userLogin.userLogin(user);
        System.out.println(result);
        assertEquals(true,result);
    }
}