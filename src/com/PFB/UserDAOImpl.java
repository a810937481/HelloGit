package com.PFB;

public class UserDAOImpl implements UserDAO{
    @Override
    public void addUser(String username, String password) {
        System.out.println(username+"用户添加成功");
    }

    @Override
    public void delUser(int id) {
        System.out.println("编号为"+id+"的用户被删除");
    }
}
