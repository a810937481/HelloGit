package com.annotation_aop;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        User user=new User();
        user.setId(resultSet.getInt("id"));
        user.setAccount(resultSet.getString("account"));
        user.setPassword(resultSet.getString("password"));
        return null;

    }
}
