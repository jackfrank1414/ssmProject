package cn.jxufe.jackfrank.controller;

import cn.jxufe.jackfrank.domain.Student;
import cn.jxufe.jackfrank.domain.vo.MessageModel;
import cn.jxufe.jackfrank.service.StudentService;
import cn.jxufe.jackfrank.service.impl.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.ValidationAnnotationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * TODO
 *
 * @author asus
 * @version 1.0
 * @date 2021/7/21 0:07
 */

@Controller
public class StudentController {
    @Resource(name = "studentService")
    private StudentService studentService;

    @RequestMapping(value = "/turnToUserView")
    public String turnToUserView(){
        return "userView";
    }

    @RequestMapping(value = "/userView")
    public ModelAndView listStudent(ModelAndView modelAndView){
        modelAndView.setViewName("userView");
        modelAndView.addObject("studentList",studentService.findAllStudents());
        return modelAndView;
    }

    @RequestMapping(value = "/turnToAddStudent")
    public String turnToAddStudent(){
        return "addStudent";
    }

    @RequestMapping(value = "/turnToDeleteStudent")
    public String turnToDeleteStudent(){
        return "deleteStudent";
    }

    @RequestMapping(value = "/turnToUpdateStudent")
    public ModelAndView turnToUpdateStudent(@RequestParam(name = "studentNo")String studentNo, ModelAndView modelAndView){
        MessageModel messageModel = new MessageModel();
        Student student = studentService.queryStudentByStudentNo(studentNo);
        messageModel.setObject(student);
        messageModel.setMsg("");

        modelAndView.setViewName("updateStudent");
        modelAndView.addObject("messageModel",messageModel);

        return modelAndView;

    }

    @RequestMapping(value = "/addStudent",method = RequestMethod.POST)
    public void addStudent(Student student, HttpServletRequest httpServletRequest){
        MessageModel messageModel = studentService.insertStudent(student);
        if(messageModel.getCode() == 1){
            httpServletRequest.setAttribute("messageModel",messageModel);
            System.out.println(messageModel.getMsg());
            System.out.println(student);
        }
        else {
            httpServletRequest.setAttribute("messageModel",messageModel);
        }
    }

    @RequestMapping(value = "/deleteStudent",method = RequestMethod.POST)
    public void deleteStudent(String studentNo,HttpServletRequest httpServletRequest){
        MessageModel messageModel = studentService.deleteStudentByStudentNo(studentNo);
        if(messageModel.getCode() == 1){
            httpServletRequest.setAttribute("messageModel",messageModel);
            System.out.println(messageModel.getMsg());
            System.out.println(studentNo);
        }
        else {
            httpServletRequest.setAttribute("messageModel",messageModel);
        }
    }

    @RequestMapping(value = "/updateStudent",method = RequestMethod.POST)
    public void updateStudent(HttpServletRequest httpServletRequest,Student student){
        MessageModel messageModel = studentService.updateStudent(student);
        if(messageModel.getCode() == 1){
            httpServletRequest.setAttribute("messageModel",messageModel);
            System.out.println(messageModel.getMsg());
            System.out.println(student);

        }
        else {
            httpServletRequest.setAttribute("messageModel",messageModel);
        }


    }
}
