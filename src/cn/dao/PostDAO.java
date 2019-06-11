package cn.dao;

import cn.domain.Post;

import java.util.List;

public interface PostDAO {

    int insertPost(Post post);
    int deletePost(int post_id);
    Post getPostById(int post_id);
    int updatePost(Post post);
    List<Post> getPostsByForumId(int forum_id);
    int getCountByForumId(int forum_id);

}
