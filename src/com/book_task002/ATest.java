package com.book_task002;

import com.book_task002.po.Person;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ATest {

    @Test
    public void findPersonByIdTest() {
        SqlSession session = MybatisUtils.getSession();
        Person person = session.selectOne("com.book_task002.mapper."+"PersonMapper.findPersonById",1);
        System.out.println(person);
        session.close();
    }

    @Test
    public void Test2(){
        SqlSession session = MybatisUtils.getSession();
        Person person = session.selectOne("com.book_task002.mapper."+"PersonMapper.findPersonById2",1);
        System.out.println(person);
        session.close();
    }

}