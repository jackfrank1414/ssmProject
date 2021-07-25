package cn.jxufe.jackfrank.service;

import cn.jxufe.jackfrank.domain.Student;
import cn.jxufe.jackfrank.domain.vo.MessageModel;

import java.util.List;

/**
 * TODO
 *
 * @author asus
 * @version 1.0
 * @date 2021/7/20 23:25
 */
public interface StudentService {
    Student queryStudentByStudentNo(String studentNo);
    Student queryStudentByStudentName(String studentName);
    MessageModel insertStudent(Student student);
    MessageModel deleteStudentByStudentNo(String studentNo);
    MessageModel deleteStudentByStudentName(String studentName);
    MessageModel updateStudent(Student student);
    List<Student> findAllStudents();
}
