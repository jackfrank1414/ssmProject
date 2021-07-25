package cn.jxufe.jackfrank.domain;

/**
 * TODO
 *
 * @author asus
 * @version 1.0
 * @date 2021/7/19 22:21
 */
public class User {
    private String userName;
    private String userPwd;

    public User() {
    }

    public User(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }
}
