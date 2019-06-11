package com.PFB;

public interface UserDAO {
    //添加用户
    public void addUser(String username,String password);
    //删除用户
    public void delUser(int id);
}
