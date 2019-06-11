package cn.dao;

import cn.domain.Forum;

public interface ForumMapper {

    public void addForum(Forum forum);
    int deleteForumById(int id);
    public int updateForum(Forum forum);

}
