package cn.dao.impl;

import cn.dao.PostDAO;
import cn.domain.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/cn_fp_applicationContext.xml"})
public class PostDAOImplTest {

    @Autowired
    private PostDAO postDAO;

    @Test
    public void insertPost() throws Exception{
        Post post = new Post();
        post.setForum_id(2);
        post.setTitle("第二论坛的帖子的标题");
        post.setContent("第二论坛的帖子的内容");
        File file = new File("C:/Users/hasee/Desktop/img/1.JPG");
        InputStream inputStream = new FileInputStream(file);
        byte[] b = new byte[(int) file.length()];
        inputStream.read(b);
        post.setThumbnail(b);
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        post.setPost_time(timestamp);
        int n = postDAO.insertPost(post);
        assertEquals(1,n);
    }

    @Test
    public void getPostById() throws Exception{
        Post post = postDAO.getPostById(2);
        System.out.println(post);
    }

    @Test
    public void updatePost() throws Exception{
        Post post = postDAO.getPostById(2);
        post.setTitle("这是修改过后的标题");
        post.setContent("这是修改过后的内容");
        int n = postDAO.updatePost(post);
        assertEquals(1,n);
    }

    @Test
    public void getPostsByForumId() {
        List<Post> posts = postDAO.getPostsByForumId(2);
        for (Post post:posts){
            System.out.println(post);
        }
    }

    @Test
    public void getCountByForumId() {
        int count = postDAO.getCountByForumId(2);
        System.out.println(count);
    }

    @Test
    public void deletePost() throws Exception{
        int n = postDAO.deletePost(3);
        assertEquals(1,n);
    }

}