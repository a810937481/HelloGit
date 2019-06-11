package cn.dao.impl;

import cn.dao.PostDAO;
import cn.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PostDao")
public class PostDAOImpl implements PostDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public int insertPost(Post post) {
        String sql="insert into t_post(forum_id,title,content,thumbnail,post_time) value(?,?,?,?,?)";
        Object[] obj = new Object[]{
                post.getForum_id(),
                post.getTitle(),
                post.getContent(),
                post.getThumbnail(),
                post.getPost_time()
        };
        int num=this.jdbcTemplate.update(sql,obj);
        return num;
    }

    @Override
    public int deletePost(int post_id) {
        String sql="delete from t_post where post_id=?";
        int num=jdbcTemplate.update(sql,post_id);
        return num;
    }

    @Override
    public Post getPostById(int post_id) {
        String sql="select*from t_post where post_id=?";
        RowMapper<Post> rowMapper=new BeanPropertyRowMapper<>(Post.class);
        return this.jdbcTemplate.queryForObject(sql,rowMapper,post_id);
    }

    @Override
    public int updatePost(Post post) {
        String sql="update t_post set title=?,content=? where post_id=?";
        Object[] params = new Object[]{
                post.getTitle(),
                post.getContent(),
                post.getPost_id()
        };
        int num=this.jdbcTemplate.update(sql,params);
        return num;
    }

    @Override
    public List<Post> getPostsByForumId(int forum_id) {
        String sql="select*from t_post where forum_id=?";
        RowMapper<Post> rowMapper=new BeanPropertyRowMapper<>(Post.class);
        return this.jdbcTemplate.query(sql,rowMapper,forum_id);
    }

    @Override
    public int getCountByForumId(int forum_id) {
        String sql="select count(*) from t_post where forum_id=?";
        int num=jdbcTemplate.queryForObject(sql,Integer.class,forum_id);
        return num;
    }
}
