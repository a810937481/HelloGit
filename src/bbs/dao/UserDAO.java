package bbs.dao;

import bbs.domain.User;

public interface UserDAO {

    User getUserByAccount(String account);
    int updateUser(User user);

}
