package bbs.dao;

import bbs.domain.Forum;

import java.util.List;
import java.util.Map;

public interface ForumDAO {

    int insertForum(Forum forum);
    List<Forum> getAllForums();
    List<Map> getPosts(int forum_id);

}
