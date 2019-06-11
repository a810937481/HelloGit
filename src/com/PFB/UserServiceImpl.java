package com.PFB;

public class UserServiceImpl implements UserService {

    UserDAO userDAO;
    public void setUserDAO(UserDAO userDAO){
        this.userDAO=userDAO;
    }

    @Override
    public void addUser(String username, String password) {
        userDAO.addUser(username,password);
    }

    @Override
    public void delUser(int id) {
        userDAO.delUser(id);
        throw new RuntimeException("这是特意抛出的异常信息！");
    }
}
