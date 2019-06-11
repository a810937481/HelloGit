package com.task6.dao;

import com.task6.MybatisUtils;
import com.task6.po.Student;
import org.apache.ibatis.session.SqlSession;

public class StudentDaoImpl implements StudentDao{


    SqlSession sqlSession;


    @Override
    public Student findStudentById(int idCard) {
        sqlSession = MybatisUtils.getSession();
        Student student = sqlSession.selectOne("com.task6.mapper."+"StudentMapper.findStudentById",idCard);
        sqlSession.commit();
        sqlSession.close();
        return student;
    }
}
