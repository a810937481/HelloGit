package com.book_task003;

import com.book_task003.po.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ATest {

    @Test
    public void findPersonByIdTest() {
        SqlSession session = MybatisUtils.getSession();
        User user = session.selectOne("com.book_task003.mapper."+"UserMapper.findUserWithOrders",1);
        System.out.println(user);
        session.close();
    }


}