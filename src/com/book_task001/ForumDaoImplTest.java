package com.book_task001;

import cn.dao.ForumDAO;
import cn.domain.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/com_book_task001_applicationContext.xml"})
public class ForumDaoImplTest {
    @Autowired
    private ForumDAO forumDao;

    @Test
    public void insertForum(){
        forumDao.insertForum(new Forum("新增论坛"));
    }
    @Test
        public void batchInsert(){
            List<Forum> forums=new ArrayList<Forum>();
            forums.add(new Forum("批量论坛1"));
            forums.add(new Forum("批量论坛2"));
            forums.add(new Forum("批量论坛3"));
            forumDao.batchInsert(forums);
        }
    @Test
    public void getAllForums(){
        List<Forum> forums = forumDao.getAllForums();
        System.out.println(forums.size());
        for (Forum forum:forums
             ) {
            System.out.println(forum);
        }
    }
}