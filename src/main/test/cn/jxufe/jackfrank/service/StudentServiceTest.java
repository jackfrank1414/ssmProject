package cn.jxufe.jackfrank.service;

import cn.jxufe.jackfrank.domain.Student;
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
 * @date 2021/7/20 23:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentServiceTest {
    @Resource(name = "studentService")
    private StudentService studentService;

    @Test
    public void test1(){
        System.out.println(studentService.queryStudentByStudentNo("15003"));
    }

    @Test
    public void test2(){
        Student student = new Student("15008","wlj");
        student.setGender("M");
        student.setBirthday("1999-08-01");
        MessageModel messageModel = studentService.insertStudent(student);
        System.out.println(messageModel.getMsg());
    }
}
