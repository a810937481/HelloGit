package com.task6;

import com.task6.dao.CourseDao;
import com.task6.dao.CourseDaoImpl;
import com.task6.dao.StudentDao;
import com.task6.dao.StudentDaoImpl;
import com.task6.po.Course;
import com.task6.po.Student;

public class Test {

    StudentDao studentDao = new StudentDaoImpl();
    CourseDao courseDao = new CourseDaoImpl();

    @org.junit.Test
    public void test(){
        Student student = studentDao.findStudentById(1);
        System.out.println(student);

        Course course = courseDao.findCourseById(1);
        System.out.println(course.getName());
    }

}
