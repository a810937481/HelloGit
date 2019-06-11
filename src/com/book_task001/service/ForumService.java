package com.book_task001.service;

import cn.domain.Forum;

public interface ForumService {
    public void addForum(Forum forum);
    int deleteForumById(int id);
    public int updateForum(Forum forum);
}
