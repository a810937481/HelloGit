package com.book_task001;

import cn.dao.PostDAO;
import cn.domain.Post;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/com_book_task001_applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostDaoImplTest {
    @Autowired
    private PostDAO postDao;
    @Test
    public void t_01_intsertPost() {
        Post post = new Post(4, "快来看", "野猪在洗澡", new byte[2], new Timestamp(new Date().getTime()));
        int n = postDao.insertPost(post);
        assertEquals(1,n);
    }

    @Test
    public void t_02_deletePost() {
        int n = postDao.deletePost(4);
        assertEquals(1,n);
    }

    @Test
    public void t_03_getPostById() {
        Post post = postDao.getPostById(2);
        System.out.println(post);
    }

    @Test
    public void t_04_updatePost() {
        Post post = new Post();
        post.setPost_id(6);
        post.setContent("野猪洗完澡了！");
        post.setForum_id(4);
        post.setTitle("野猪爱洗澡");
        post.setPost_time(new Timestamp(new Date().getTime()));
        int n = postDao.updatePost(post);
        assertEquals(1, n);
    }

    @Test
    public void t_06_getPostsByForum() {
        List<Post> posts = postDao.getPostsByForumId(2);
        for (Post post:posts) {
            System.out.println(post);
        }
    }

    @Test
    public void t_05_getCountByForumId() {
        System.out.println(postDao.getCountByForumId(1));
    }
}