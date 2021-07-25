package cn.jxufe.jackfrank.controller;

import cn.jxufe.jackfrank.domain.vo.MessageModel;
import cn.jxufe.jackfrank.service.UserService;
import javafx.scene.chart.ValueAxis;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @author asus
 * @version 1.0
 * @date 2021/7/19 22:37
 */
@Controller
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(value = "/login",produces = "text/html;charset=utf-8",method = RequestMethod.POST)
    public String loginController(@RequestParam(name = "uname") String userName, @RequestParam(name = "upwd") String userPwd, HttpServletRequest httpServletRequest){
        MessageModel messageModel = userService.userLogin(userName,userPwd);
        if(messageModel.getCode() == 1){
            return "postHouse";
        }
        else {
            httpServletRequest.setAttribute("messageModel",messageModel);
            return "login";
        }
    }

    @RequestMapping(value = "/login2",produces = "text/html;charset=utf-8",method = RequestMethod.POST)
    public String loginController2(@RequestParam(name = "Name") String userName, @RequestParam(name = "Password") String userPwd, HttpServletRequest httpServletRequest){
        MessageModel messageModel = userService.userLogin(userName,userPwd);
        if(messageModel.getCode() == 1){
            return "postHouse";
        }
        else {
            httpServletRequest.setAttribute("messageModel",messageModel);
            return "login2";
        }
    }


    @RequestMapping(value = "/register")
    public String register(String uname, String upwd, String upwdAg,HttpServletRequest httpServletRequest){
        MessageModel messageModel = userService.userRegister(uname, upwd, upwdAg);

        if(messageModel.getCode() == 1){
            return "login";
        }
        else {
            httpServletRequest.setAttribute("messageModel",messageModel);
            return "register";
        }
    }

    @RequestMapping(value = "/register2")
    public String register2(String uname, String upwd, String upwdAg,HttpServletRequest httpServletRequest){
        MessageModel messageModel = userService.userRegister(uname, upwd, upwdAg);

        if(messageModel.getCode() == 1){
            return "login2";
        }
        else {
            httpServletRequest.setAttribute("messageModel",messageModel);
            return "register2";
        }
    }


}
