package com.task6.dao;

import com.task6.MybatisUtils;
import com.task6.po.Course;
import org.apache.ibatis.session.SqlSession;

public class CourseDaoImpl implements CourseDao {


    SqlSession sqlSession;

    @Override
    public Course findCourseById(int courseId) {
        sqlSession = MybatisUtils.getSession();
        Course course = sqlSession.selectOne("com.task6.mapper."+"CourseMapper.findCourseById",courseId);
        sqlSession.commit();
        sqlSession.close();
        return course;
    }
}
