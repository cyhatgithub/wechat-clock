package com.yinghao.service;

import com.yinghao.domain.Course;

/**
 * Created by chenyinghao on 2019/9/18.
 */
public interface CourseServiceInter extends BaseServiceInter<Course> {
    /**
     * 定时发送课程
     */
    public void sendCourseTask();
}
