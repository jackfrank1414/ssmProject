package cn.jxufe.jackfrank.domain;

/**
 * TODO
 *
 * @author asus
 * @version 1.0
 * @date 2021/7/25 15:24
 */
public class Course {
    private String courseNo;
    private String courseName;
    private String hour;
    private String credit;

    public Course() {
    }

    public Course(String courseNo, String courseName, String hour, String credit) {
        this.courseNo = courseNo;
        this.courseName = courseName;
        this.hour = hour;
        this.credit = credit;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseNo='" + courseNo + '\'' +
                ", courseName='" + courseName + '\'' +
                ", hour='" + hour + '\'' +
                ", credit='" + credit + '\'' +
                '}';
    }
}
