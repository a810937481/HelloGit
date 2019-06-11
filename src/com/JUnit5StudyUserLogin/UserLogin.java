package com.JUnit5StudyUserLogin;

public class UserLogin {

    private User user;

    public UserLogin(User user) {
        super();
        this.user = user;
    }

    public UserLogin(){super();}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean userLogin(User user){
        boolean T=false;
        if (user.getAccount().equals("admin")&&user.getPassword().equals("111")){
            T=true;
        }
        return T;
    }

}
