package cn.jxufe.jackfrank.service;

import cn.jxufe.jackfrank.domain.vo.MessageModel;

/**
 * TODO
 *
 * @author asus
 * @version 1.0
 * @date 2021/7/19 22:28
 */
public interface UserService {
    MessageModel userLogin(String uname, String upwd);
    MessageModel userRegister(String uname, String upwd, String upwdAg);
}
