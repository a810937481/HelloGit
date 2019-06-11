package com.annotation_aop;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository("userDao")
public class UserDAOImpl implements UserDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertUser(User user) {
        String sql="insert into t_user(account,password) value(?,?)";
        Object[] obj = new Object[]{
                user.getAccount(),
                user.getPassword()
        };
        int num=this.jdbcTemplate.update(sql,obj);
        return num;
    }

    @Override
    public int updateUser(User user,int id) {
        String sql="update t_user set account=?,password=? where id=?";
        Object[] params = new Object[]{
                user.getAccount(),
                user.getPassword(),
                id
        };
        int num=this.jdbcTemplate.update(sql,params);
        return num;
    }

    @Override
    public int deleteUser(int id) {
        String sql="delete from t_user where id=?";
        int num=this.jdbcTemplate.update(sql,id);
        return num;
    }

    @Override
    public List<User> getAllUser() {
        String sql="SELECT * FROM t_user";
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<>(User.class);
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public User getUserById(Integer id) {
        String sql="SELECT * FROM t_user WHERE id=?";
        RowMapper<User>rowMapper=new BeanPropertyRowMapper<User>(User.class);
        return this.jdbcTemplate.queryForObject(sql, rowMapper,id);
    }

    @Override
    public void batchInsert(List<User> users) {

        List<User> userList=users;
        String sql="insert into t_user values(null,?,?)";
        jdbcTemplate.batchUpdate(
                sql, new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                        preparedStatement.setString(1,userList.get(i).getAccount());
                        preparedStatement.setString(2,userList.get(i).getPassword());
                    }

                    @Override
                    public int getBatchSize() {
                        return userList.size();
                    }
                }
        );

    }
}
