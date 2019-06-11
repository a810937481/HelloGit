package com.book_task001;

import cn.domain.Forum;
import com.book_task001.service.ForumService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com_book_task001_applicationContext.xml");
        ForumService forumService = applicationContext.getBean(ForumService.class);
        Forum forum = new Forum("MS整合实验001");
        forum.setForum_id(8);
        forumService.updateForum(forum);
    }
}
