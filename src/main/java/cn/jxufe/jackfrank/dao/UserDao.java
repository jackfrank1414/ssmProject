package cn.jxufe.jackfrank.dao;

import cn.jxufe.jackfrank.domain.User;

import java.util.List;

/**
 * TODO
 *
 * @author asus
 * @version 1.0
 * @date 2021/7/19 22:24
 */
public interface UserDao {
    User queryUserByName(String userName);
    boolean addUser(User user);
    List<User> findAllUsers();
}
