package cn.jxufe.jackfrank.service.impl;

import cn.jxufe.jackfrank.dao.CourseDao;
import cn.jxufe.jackfrank.domain.Course;
import cn.jxufe.jackfrank.domain.vo.MessageModel;
import cn.jxufe.jackfrank.service.CourseService;
import cn.jxufe.jackfrank.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 *
 * @author asus
 * @version 1.0
 * @date 2021/7/25 15:49
 */

@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Resource(name = "courseDao")
    private CourseDao courseDao;

    @Override
    public Course queryCourseByCourseNo(String courseNo) {
        return courseDao.queryCourseByCourseNo(courseNo);
    }

    @Override
    public Course queryCourseByCourseName(String courseName) {
        return courseDao.queryCourseByCourseName(courseName);
    }

    @Override
    public MessageModel insertCourse(Course course) {
        MessageModel messageModel = new MessageModel();
        messageModel.setObject(course);

        if(StringUtil.isEmpty(course.getCourseNo()) || StringUtil.isEmpty(course.getCourseName()) || StringUtil.isEmpty(course.getHour()) || StringUtil.isEmpty(course.getCredit())){
            messageModel.setCode(0);
            if(StringUtil.isEmpty(course.getCourseNo())){
                messageModel.setMsg("课程编号不能为空！");
            }
            else if(StringUtil.isEmpty(course.getCourseName())){
                messageModel.setMsg("课程名称不能为空！");
            }
            else if(StringUtil.isEmpty(course.getHour())){
                messageModel.setMsg("课程学时不能为空！");
            }
            else {
                messageModel.setMsg("课程学分不能为空！");
            }
        }
        if(!courseDao.insertCourse(course)){
            messageModel.setCode(0);
            messageModel.setMsg("系统错误！");
        }

        return messageModel;
    }

    @Override
    public MessageModel deleteCourse(String courseNo) {
        MessageModel messageModel = new MessageModel();

        if(courseDao.queryCourseByCourseNo(courseNo) == null){
            messageModel.setCode(0);
            messageModel.setMsg("不存在该课程！");
        }
        if(!courseDao.deleteCourse(courseNo)){
            messageModel.setCode(0);
            messageModel.setMsg("系统错误！");
        }

        return messageModel;
    }

    @Override
    public MessageModel updateCourse(Course course) {
        MessageModel messageModel = new MessageModel();
        messageModel.setObject(course);

        if(StringUtil.isEmpty(course.getCourseNo()) || StringUtil.isEmpty(course.getCourseName()) || StringUtil.isEmpty(course.getHour()) || StringUtil.isEmpty(course.getCredit())){
            messageModel.setCode(0);
            if(StringUtil.isEmpty(course.getCourseNo())){
                messageModel.setMsg("课程编号不能为空！");
            }
            else if(StringUtil.isEmpty(course.getCourseName())){
                messageModel.setMsg("课程名称不能为空！");
            }
            else if(StringUtil.isEmpty(course.getHour())){
                messageModel.setMsg("课程学时不能为空！");
            }
            else {
                messageModel.setMsg("课程学分不能为空！");
            }
        }

        if(!courseDao.updateCourse(course)){
            messageModel.setCode(0);
            messageModel.setMsg("系统错误！");
        }

        return messageModel;
    }

    @Override
    public List<Course> findAllCourse() {
        return courseDao.findAllCourse();
    }
}
