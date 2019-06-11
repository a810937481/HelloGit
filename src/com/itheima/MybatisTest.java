package com.itheima;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void findCustomerByIdTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Customer customer = sqlSession.selectOne("com.itheima"+".CustomerMapper.findCustomerById",4);
        System.out.println(customer.toString());
        List<Customer> customers = sqlSession.selectList("com.itheima"+".CustomerMapper.findCustomerByName","t");
        for (Customer customer1 : customers){
            System.out.println(customer1);
        }
        Customer customer2 = new Customer();
        customer2.setUsername("ddd");
        customer2.setJobs("dafdaf");
        customer2.setPhone("176156971");
        int rows = sqlSession.insert("com.itheima"+".CustomerMapper.addCustomer",customer2);
        if(rows > 0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }

        customer2.setId(6);
        customer2.setJobs("ppppppppppppp");
        customer2.setPhone("3545135154981532");
        int rows2 = sqlSession.update("com.itheima"+".CustomerMapper.updateCustomer",customer2);
        if (rows2 > 0){
            System.out.println("修改成功"+rows2+"条数据");
        }else {
            System.out.println("修改失败");
        }

        int rows3 = sqlSession.delete("com.itheima"+".CustomerMapper.deleteCustomer",4);
        if (rows3 > 0){
            System.out.println("成功删除"+rows3+"条数据");
        }else {
            System.out.println("删除失败");
        }

        sqlSession.commit();
        sqlSession.close();
    }

}
