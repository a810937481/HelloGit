package cn.dao;

import cn.domain.Forum;

import java.util.List;

public interface ForumDAO {

    int insertForum(Forum forum);
    List<Forum> getAllForums();
    void batchInsert(List<Forum> forums);

}
