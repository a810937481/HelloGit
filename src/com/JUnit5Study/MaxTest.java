package com.JUnit5Study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)//指定单元测试的运行环境
@ContextConfiguration(locations = {"maxbeans.xml"})//指定配置文件路径
class MaxTest {

    @Autowired//自动加载配置文件中的Max的实例max
    private Max max;

    @Test
    void getMax() throws Exception{
            int result=max.getMax();
            System.out.println(result);
            assertEquals(10,result);
    }
}