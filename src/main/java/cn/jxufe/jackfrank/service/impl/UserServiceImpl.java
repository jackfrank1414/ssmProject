package cn.jxufe.jackfrank.service.impl;

import cn.jxufe.jackfrank.dao.UserDao;
import cn.jxufe.jackfrank.domain.User;
import cn.jxufe.jackfrank.domain.vo.MessageModel;
import cn.jxufe.jackfrank.service.UserService;
import cn.jxufe.jackfrank.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author asus
 * @version 1.0
 * @date 2021/7/19 22:28
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public MessageModel userLogin(String uname, String upwd) {
        MessageModel messageModel = new MessageModel();

        User u = new User();
        u.setUserName(uname);
        u.setUserPwd(upwd);
        messageModel.setObject(u);

        if(StringUtil.isEmpty(uname) || StringUtil.isEmpty(upwd)){
            messageModel.setCode(0);
            messageModel.setMsg("用户名和密码不能为空！");

            return messageModel;
        }


        User user = userDao.queryUserByName(uname);

        if(user == null){
            messageModel.setCode(0);
            messageModel.setMsg("用户不存在！");
            return messageModel;
        }

        if (!upwd.equals(user.getUserPwd())){
            messageModel.setCode(0);
            messageModel.setMsg("用户密码不正确！");
            return messageModel;
        }



        messageModel.setObject(user);

        return messageModel;
    }

    @Override
    public MessageModel userRegister(String uname, String upwd, String upwdAg) {
        MessageModel messageModel = new MessageModel();
        User u = new User();
        u.setUserName(uname);
        u.setUserPwd(upwd);
        messageModel.setObject(u);

        if(StringUtil.isEmpty(uname) || StringUtil.isEmpty(upwd)){
            messageModel.setCode(0);
            messageModel.setMsg("用户名和密码不能为空！");

            return messageModel;
        }

        if (!upwdAg.equals(upwd)){
            messageModel.setCode(0);
            messageModel.setMsg("两次输入的密码不一致！");
        }


        User user = userDao.queryUserByName(uname);

        if(user != null){
            messageModel.setCode(0);
            messageModel.setMsg("用户已存在！请更换用户名！");
            return messageModel;
        }

        User new_user = new User(uname,upwd);
        if(userDao.addUser(new_user)){
//            session.commit();
            System.out.println("注册成功！");
        }

        messageModel.setObject(new_user);

        return messageModel;
    }
}
