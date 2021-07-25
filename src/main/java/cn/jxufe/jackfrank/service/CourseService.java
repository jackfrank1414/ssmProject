package cn.jxufe.jackfrank.service;

import cn.jxufe.jackfrank.domain.Course;
import cn.jxufe.jackfrank.domain.vo.MessageModel;

import java.util.List;

/**
 * TODO
 *
 * @author asus
 * @version 1.0
 * @date 2021/7/25 15:48
 */
public interface CourseService {

    Course queryCourseByCourseNo(String courseNo);
    Course queryCourseByCourseName(String courseName);
    MessageModel insertCourse(Course course);
    MessageModel deleteCourse(String courseNo);
    MessageModel updateCourse(Course course);
    List<Course> findAllCourse();
}
