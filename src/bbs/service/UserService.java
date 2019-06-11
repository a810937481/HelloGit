package bbs.service;

import bbs.domain.User;

public interface UserService {

    User getUserByAccount(String account);
    void updateUser(User user);
    boolean login(String account, String password);

}
