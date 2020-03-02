package com.yinghao.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "course_detail")
public class CourseDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 课程名称
     */
    @Column(name = "course_name")
    private String courseName;

    /**
     * 教室地址
     */
    @Column(name = "class_room")
    private String classRoom;

    @Column(name = "course_begin_week")
    private Integer courseBeginWeek;

    @Column(name = "course_end_week")
    private Integer courseEndWeek;

    /**
     * 上课开始时间（hh:mm:ss）
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 上课结束时间（hh:mm:ss）
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 0:每周上/1:单周上/2:双周上
     */
    @Column(name = "class_model")
    private Integer classModel;

    /**
     * 学期描述id（从term表可以获取学期开始/结束时间）
     */
    @Column(name = "term_id")
    private Integer termId;

    /**
     * 上课人
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 上课人
     */
    @Column(name = "week_day")
    private String weekDay;

    private Term term;

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

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
     * 获取教室地址
     *
     * @return class_room - 教室地址
     */
    public String getClassRoom() {
        return classRoom;
    }

    /**
     * 设置教室地址
     *
     * @param classRoom 教室地址
     */
    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom == null ? null : classRoom.trim();
    }

    /**
     * @return course_begin_week
     */
    public Integer getCourseBeginWeek() {
        return courseBeginWeek;
    }

    /**
     * @param courseBeginWeek
     */
    public void setCourseBeginWeek(Integer courseBeginWeek) {
        this.courseBeginWeek = courseBeginWeek;
    }

    /**
     * @return course_end_week
     */
    public Integer getCourseEndWeek() {
        return courseEndWeek;
    }

    /**
     * @param courseEndWeek
     */
    public void setCourseEndWeek(Integer courseEndWeek) {
        this.courseEndWeek = courseEndWeek;
    }

    /**
     * 获取上课开始时间（hh:mm:ss）
     *
     * @return start_time - 上课开始时间（hh:mm:ss）
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置上课开始时间（hh:mm:ss）
     *
     * @param startTime 上课开始时间（hh:mm:ss）
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取上课结束时间（hh:mm:ss）
     *
     * @return end_time - 上课结束时间（hh:mm:ss）
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置上课结束时间（hh:mm:ss）
     *
     * @param endTime 上课结束时间（hh:mm:ss）
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取0:每周上/1:单周上/2:双周上
     *
     * @return class_model - 0:每周上/1:单周上/2:双周上
     */
    public Integer getClassModel() {
        return classModel;
    }

    /**
     * 设置0:每周上/1:单周上/2:双周上
     *
     * @param classModel 0:每周上/1:单周上/2:双周上
     */
    public void setClassModel(Integer classModel) {
        this.classModel = classModel;
    }

    /**
     * 获取学期描述id（从term表可以获取学期开始/结束时间）
     *
     * @return term_id - 学期描述id（从term表可以获取学期开始/结束时间）
     */
    public Integer getTermId() {
        return termId;
    }

    /**
     * 设置学期描述id（从term表可以获取学期开始/结束时间）
     *
     * @param termId 学期描述id（从term表可以获取学期开始/结束时间）
     */
    public void setTermId(Integer termId) {
        this.termId = termId;
    }

    /**
     * 获取上课人
     *
     * @return user_id - 上课人
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置上课人
     *
     * @param userId 上课人
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }
}