package cn.dao.impl;

import cn.dao.ForumDAO;
import cn.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository("ForumDao")
public class ForumDAOImpl implements ForumDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertForum(Forum forum) {
        String sql="insert into t_forum(name) value(?)";
        Object[] obj = new Object[]{
                forum.getName()
        };
        int num=this.jdbcTemplate.update(sql,obj);
        return num;
    }

    @Override
    public List<Forum> getAllForums() {
        String sql="SELECT * FROM t_forum";
        RowMapper<Forum> rowMapper=new BeanPropertyRowMapper<>(Forum.class);
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void batchInsert(List<Forum> forums) {

        List<Forum> forumList=forums;
        String sql="insert into t_forum values(null,?)";
        jdbcTemplate.batchUpdate(
                sql, new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                        preparedStatement.setString(1,forumList.get(i).getName());
                    }

                    @Override
                    public int getBatchSize() {
                        return forumList.size();
                    }
                }
        );

    }

}
