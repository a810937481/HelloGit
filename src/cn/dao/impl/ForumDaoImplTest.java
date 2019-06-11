package cn.dao.impl;

import cn.dao.ForumDAO;
import cn.domain.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/cn_fp_applicationContext.xml"})
public class ForumDaoImplTest {

    @Autowired
    private ForumDAO forumDAO;

    @Test
    public void insertForum() throws Exception{
        Forum forum=new Forum("test");
        int n=forumDAO.insertForum(forum);
        assertEquals(1, n);
    }

    @Test
    public void batchInsert() throws Exception{
        List<Forum> forumList=new ArrayList<Forum>();
        forumList.add(new Forum("haha"));
        forumList.add(new Forum("hehe"));
        forumList.add(new Forum("rua"));
        forumDAO.batchInsert(forumList);
    }

    @Test
    public void getAllForums() throws Exception{
        List<Forum> forumList = forumDAO.getAllForums();
        for (Forum forum: forumList){
            System.out.println(forum);
        }
    }

}