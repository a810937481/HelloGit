package bbs.service.impl;

import bbs.dao.UserDAO;
import bbs.domain.User;
import bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User getUserByAccount(String account) {
        return userDAO.getUserByAccount(account);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public boolean login(String account, String password) {
        User user = userDAO.getUserByAccount(account);
        if (user != null){
            if (password.equals(user.getPassword())){
                System.out.println("测试"+user.getPoint());
                user.setPoint(user.getPoint()+100);
                userDAO.updateUser(user);
                return true;
            }
        }
        return false;
    }
}
