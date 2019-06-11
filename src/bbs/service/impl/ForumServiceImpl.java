package bbs.service.impl;

import bbs.dao.ForumDAO;
import bbs.domain.Forum;
import bbs.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumDAO forumDAO;

    @Override
    public int insertForum(Forum forum) {
        return forumDAO.insertForum(forum);
    }

    @Override
    public List<Forum> getAllForums() {
        return forumDAO.getAllForums();
    }

    @Override
    public List<Map> getPosts(int forum_id) {
        return forumDAO.getPosts(forum_id);
    }
}
