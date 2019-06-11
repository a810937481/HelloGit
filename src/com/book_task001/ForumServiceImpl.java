package com.book_task001;

import cn.dao.ForumMapper;
import cn.domain.Forum;
import com.book_task001.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumMapper forumMapper;

    @Override
    public void addForum(Forum forum) {
        this.forumMapper.addForum(forum);
    }

    @Override
    public int deleteForumById(int id) {
        return this.forumMapper.deleteForumById(id);
    }

    @Override
    public int updateForum(Forum forum) {
        return this.forumMapper.updateForum(forum);
    }

}
