package cn.jxufe.jackfrank.dao;

import cn.jxufe.jackfrank.domain.Student;

import java.util.List;

/**
 * TODO
 *
 * @author asus
 * @version 1.0
 * @date 2021/7/20 22:27
 */
public interface StudentDao {

    Student queryStudentByStudentNo(String studentNo);
    Student queryStudentByStudentName(String studentName);
    Boolean insertStudent(Student student);
    Boolean deleteStudentByStudentNo(String studentNo);
    Boolean deleteStudentByStudentName(String studentName);
    Boolean updateStudent(Student student);
    List<Student> findAllStudents();

}
