package bbs.domain;

public class User {

    private String account;
    private String password;
    private String nickname;
    private String avatar;
    private Integer point;

    public User(){}

    public User(String account, String password){
        this.account = account;
        this.password = password;
    }

    public User(String account, String password, String nickname, String avatar, Integer point) {
        this.account = account;
        this.password = password;
        this.nickname = nickname;
        this.avatar = avatar;
        this.point = point;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer points) {
        this.point = points;
    }
}
