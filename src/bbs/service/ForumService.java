package bbs.service;

import bbs.domain.Forum;

import java.util.List;
import java.util.Map;

public interface ForumService {

    int insertForum(Forum forum);
    List<Forum> getAllForums();
    List<Map> getPosts(int forum_id);

}
