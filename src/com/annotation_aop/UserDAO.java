package com.annotation_aop;

import java.util.List;

public interface UserDAO {
    int insertUser(User user);
    int updateUser(User user,int id);
    int deleteUser(int id);
    List<User> getAllUser();
    User getUserById(Integer id);

    void batchInsert(List<User> users);

}
