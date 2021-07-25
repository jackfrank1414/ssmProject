package cn.jxufe.jackfrank.service;

import cn.jxufe.jackfrank.domain.Course;
import cn.jxufe.jackfrank.domain.vo.MessageModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.annotation.Resource;

/**
 * TODO
 *
 * @author asus
 * @version 1.0
 * @date 2021/7/25 19:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CourseServiceTest {
    @Resource(name = "courseService")
    private CourseService courseService;

    @Test
    public void test1(){
        System.out.println(courseService.findAllCourse());
    }

    @Test
    public void test2(){
        Course course1 = courseService.queryCourseByCourseNo("1");
        Course course2 = courseService.queryCourseByCourseName("概率论");
        System.out.println(course2);
    }

    @Test
    public void test3(){
        MessageModel messageModel = courseService.deleteCourse("123");
        System.out.println(messageModel.getMsg());
    }

}
