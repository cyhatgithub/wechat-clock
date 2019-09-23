package com.yinghao.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 上课时间（年月日是第一次上课的时间，用来计算星期几）
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 下课时间（年月日是第一次上课的时间，用来计算星期几）
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 课程名称
     */
    @Column(name = "course_name")
    private String courseName;

    /**
     * 上课老师
     */
    private String teacher;

    /**
     * 上课教室
     */
    private String classroom;

    /**
     * 课程开始时间
     */
    @Column(name = "begin_time")
    private Date beginTime;

    /**
     * 课程结束时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    /**
     * 是否单周上课
     */
    @Column(name = "isSingle")
    private String issingle;

    @Column(name = "user_open_id")
    private String userOpenId;

    @Column(name = "user_name")
    private String userName;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取上课时间（年月日是第一次上课的时间，用来计算星期几）
     *
     * @return start_time - 上课时间（年月日是第一次上课的时间，用来计算星期几）
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置上课时间（年月日是第一次上课的时间，用来计算星期几）
     *
     * @param startTime 上课时间（年月日是第一次上课的时间，用来计算星期几）
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取下课时间（年月日是第一次上课的时间，用来计算星期几）
     *
     * @return end_time - 下课时间（年月日是第一次上课的时间，用来计算星期几）
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置下课时间（年月日是第一次上课的时间，用来计算星期几）
     *
     * @param endTime 下课时间（年月日是第一次上课的时间，用来计算星期几）
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取课程名称
     *
     * @return course_name - 课程名称
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * 设置课程名称
     *
     * @param courseName 课程名称
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    /**
     * 获取上课老师
     *
     * @return teacher - 上课老师
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * 设置上课老师
     *
     * @param teacher 上课老师
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    /**
     * 获取上课教室
     *
     * @return classroom - 上课教室
     */
    public String getClassroom() {
        return classroom;
    }

    /**
     * 设置上课教室
     *
     * @param classroom 上课教室
     */
    public void setClassroom(String classroom) {
        this.classroom = classroom == null ? null : classroom.trim();
    }

    /**
     * 获取课程开始时间
     *
     * @return begin_time - 课程开始时间
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * 设置课程开始时间
     *
     * @param beginTime 课程开始时间
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 获取课程结束时间
     *
     * @return finish_time - 课程结束时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置课程结束时间
     *
     * @param finishTime 课程结束时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取是否单周上课
     *
     * @return isSingle - 是否单周上课
     */
    public String getIssingle() {
        return issingle;
    }

    /**
     * 设置是否单周上课
     *
     * @param issingle 是否单周上课
     */
    public void setIssingle(String issingle) {
        this.issingle = issingle == null ? null : issingle.trim();
    }

    /**
     * @return user_open_id
     */
    public String getUserOpenId() {
        return userOpenId;
    }

    /**
     * @param userOpenId
     */
    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId == null ? null : userOpenId.trim();
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}