package cn.jxufe.jackfrank.controller;

import cn.jxufe.jackfrank.domain.Course;
import cn.jxufe.jackfrank.domain.Student;
import cn.jxufe.jackfrank.domain.vo.MessageModel;
import cn.jxufe.jackfrank.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @author asus
 * @version 1.0
 * @date 2021/7/25 20:11
 */

@Controller
//@RequestMapping(value = "/course")
public class CourseController {
    @Resource(name = "courseService")
    private CourseService courseService;

    @RequestMapping(value = "/courseView")
    public ModelAndView listStudent(ModelAndView modelAndView){
        modelAndView.setViewName("courseView");
        modelAndView.addObject("courseList",courseService.findAllCourse());
        return modelAndView;
    }

    @RequestMapping(value = "/turnToAddCourse")
    public String turnToAddCourse(){
        return "addCourse";
    }

    @RequestMapping(value = "/addCourse",method = RequestMethod.POST)
    public void addCourse(Course course, HttpServletRequest httpServletRequest){
        MessageModel messageModel = courseService.insertCourse(course);
        if(messageModel.getCode() == 1){
            httpServletRequest.setAttribute("messageModel",messageModel);
            System.out.println(messageModel.getMsg());
            System.out.println(course);
        }
        else {
            httpServletRequest.setAttribute("messageModel",messageModel);
        }
    }

    @RequestMapping(value = "/turnToUpdateCourse")
    public ModelAndView turnToUpdateStudent(@RequestParam(name = "courseNo")String courseNo, ModelAndView modelAndView){
        MessageModel messageModel = new MessageModel();
        Course course = courseService.queryCourseByCourseNo(courseNo);
        messageModel.setObject(course);
        messageModel.setMsg("");

        modelAndView.setViewName("updateCourse");
        modelAndView.addObject("messageModel",messageModel);

        return modelAndView;

    }

    @RequestMapping(value = "/updateCourse",method = RequestMethod.POST)
    public void updateStudent(HttpServletRequest httpServletRequest,Course course){
        MessageModel messageModel = courseService.updateCourse(course);
        if(messageModel.getCode() == 1){
            httpServletRequest.setAttribute("messageModel",messageModel);
            System.out.println(messageModel.getMsg());
            System.out.println(course);

        }
        else {
            httpServletRequest.setAttribute("messageModel",messageModel);
        }
    }

    @RequestMapping(value = "/turnToDeleteCourse")
    public String turnToDeleteCourse(){
        return "deleteCourse";
    }

    @RequestMapping(value = "/deleteCourse",method = RequestMethod.POST)
    public void deleteStudent(String courseNo,HttpServletRequest httpServletRequest){
        MessageModel messageModel = courseService.deleteCourse(courseNo);
        if(messageModel.getCode() == 1){
            httpServletRequest.setAttribute("messageModel",messageModel);
            System.out.println(messageModel.getMsg());
            System.out.println(courseNo);
        }
        else {
            httpServletRequest.setAttribute("messageModel",messageModel);
        }
    }

}
