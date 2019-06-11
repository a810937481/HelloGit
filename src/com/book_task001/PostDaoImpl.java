package com.book_task001;

import cn.dao.PostDAO;
import cn.domain.Post;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PostDao")
public class PostDaoImpl implements PostDAO {
    SqlSession sqlSession;

    @Override
    public int insertPost(Post post) {
        sqlSession = MybatisUtils.getSession();
        int num = sqlSession.insert("insertPost", post);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public int deletePost(int post_id) {
        sqlSession = MybatisUtils.getSession();
        int num = sqlSession.delete("deletePost", post_id);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public Post getPostById(int post_id) {
        sqlSession = MybatisUtils.getSession();
        Post post=sqlSession.selectOne("getPostById",post_id);
        return post;
    }

    @Override
    public int updatePost(Post post) {
        sqlSession = MybatisUtils.getSession();
        int num = sqlSession.update("updatePost", post);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public List<Post> getPostsByForumId(int forum_id) {
        sqlSession = MybatisUtils.getSession();
        List<Post> posts = sqlSession.selectList("getPostsByForum", forum_id);
        return posts;
    }

    @Override
    public int getCountByForumId(int forum_id) {
        sqlSession = MybatisUtils.getSession();
        List<Post> posts = sqlSession.selectList("getPostsByForum", forum_id);
        return posts.size();
    }
}
