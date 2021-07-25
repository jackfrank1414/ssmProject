package cn.jxufe.jackfrank.domain;

import java.util.Objects;

/**
 * TODO
 *
 * @author asus
 * @version 1.0
 * @date 2021/7/20 21:46
 */
public class Student {
    private String studentNo;
    private String studentName;
    private String gender;
    private String birthday;

    public Student() {
    }

    public Student(String studentNo, String studentName) {
        this.studentNo = studentNo;
        this.studentName = studentName;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNo='" + studentNo + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return getStudentNo().equals(student.getStudentNo()) &&
                getStudentName().equals(student.getStudentName()) &&
                getGender().equals(student.getGender()) &&
                getBirthday().equals(student.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentNo(), getStudentName(), getGender(), getBirthday());
    }
}
