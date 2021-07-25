package cn.jxufe.jackfrank.dao;

import cn.jxufe.jackfrank.domain.Course;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * TODO
 *
 * @author asus
 * @version 1.0
 * @date 2021/7/25 15:35
 */
public interface CourseDao {
    Course queryCourseByCourseNo(String courseNo);
    Course queryCourseByCourseName(String courseName);
    Boolean insertCourse(Course course);
    Boolean deleteCourse(String courseNo);
    Boolean updateCourse(Course course);
    List<Course> findAllCourse();

}
