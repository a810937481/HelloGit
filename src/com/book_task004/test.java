package com.book_task004;

import com.book_task004.po.Orders;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class test {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSession();
        Orders orders = sqlSession.selectOne("com.book_task004.mapper."+"OrdersMapper.findOrdersWithPorduct",1);
        System.out.println(orders);
        sqlSession.close();
    }

}
