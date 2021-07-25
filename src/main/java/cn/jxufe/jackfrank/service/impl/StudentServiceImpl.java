package cn.jxufe.jackfrank.service.impl;

import cn.jxufe.jackfrank.dao.StudentDao;
import cn.jxufe.jackfrank.domain.Student;
import cn.jxufe.jackfrank.domain.vo.MessageModel;
import cn.jxufe.jackfrank.service.StudentService;
import cn.jxufe.jackfrank.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 *
 * @author asus
 * @version 1.0
 * @date 2021/7/20 23:25
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource(name = "studentDao")
    private StudentDao studentDao;


    @Override
    public Student queryStudentByStudentNo(String studentNo) {
        return studentDao.queryStudentByStudentNo(studentNo);
    }

    @Override
    public Student queryStudentByStudentName(String studentName) {
        return studentDao.queryStudentByStudentName(studentName);
    }

    @Override
    public MessageModel insertStudent(Student student) {
        MessageModel messageModel = new MessageModel();
        messageModel.setObject(student);

        if(StringUtil.isEmpty(student.getStudentNo()) || StringUtil.isEmpty(student.getStudentName())
            || StringUtil.isEmpty(student.getGender()) || StringUtil.isEmpty(student.getBirthday())){
            messageModel.setCode(0);
            messageModel.setMsg("学生信息不能为空!");
            return messageModel;
        }
        else {
            if(studentDao.queryStudentByStudentNo(student.getStudentNo()) != null){
                messageModel.setCode(0);
                messageModel.setMsg("该学号已存在！");
                return messageModel;
            }
            if (!studentDao.insertStudent(student)) {
                messageModel.setCode(0);
                messageModel.setMsg("系统错误！");
                return messageModel;
            }
        }

        return messageModel;
    }

    @Override
    public MessageModel deleteStudentByStudentNo(String studentNo) {
        MessageModel messageModel = new MessageModel();

        if(StringUtil.isEmpty(studentNo)){
            messageModel.setCode(0);
            messageModel.setMsg("学号不能为空！");
        }
        else if(studentDao.queryStudentByStudentNo(studentNo) == null){
            messageModel.setCode(0);
            messageModel.setMsg("不存在该学生！");
        }
        else {
            if(!studentDao.deleteStudentByStudentNo(studentNo)){
                messageModel.setCode(0);
                messageModel.setMsg("系统错误！");
            }
        }

        return messageModel;
    }

    @Override
    public MessageModel deleteStudentByStudentName(String studentName) {
        MessageModel messageModel = new MessageModel();

        if(studentDao.queryStudentByStudentName(studentName) == null){
            messageModel.setCode(0);
            messageModel.setMsg("不存在该学生！");
        }
        else {
            if(!studentDao.deleteStudentByStudentName(studentName)){
                messageModel.setCode(0);
                messageModel.setMsg("系统错误！");
            }
        }

        return messageModel;
    }

    @Override
    public MessageModel updateStudent(Student student) {
        MessageModel messageModel = new MessageModel();
        messageModel.setObject(student);
        Student oldStudent = studentDao.queryStudentByStudentNo(student.getStudentNo());

        if(oldStudent.equals(student)){
            messageModel.setMsg("");
            return messageModel;
        }

        if(StringUtil.isEmpty(student.getStudentNo()) || StringUtil.isEmpty(student.getStudentName())){
            messageModel.setCode(0);
            messageModel.setMsg("学生主要信息（学号+姓名）不能为空！");
        }
        else {
            if(!StringUtil.isValidGender(student.getGender())){
                messageModel.setCode(0);
                messageModel.setMsg("学生性别格式不正确！");
            }
            else {
                if(!studentDao.updateStudent(student)){
                    messageModel.setCode(0);
                    messageModel.setMsg("系统错误！");
                }
            }
        }

        return messageModel;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentDao.findAllStudents();
    }
}
