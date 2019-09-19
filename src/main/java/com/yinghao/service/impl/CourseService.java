package com.yinghao.service.impl;

import com.yinghao.dao.CourseMapper;
import com.yinghao.domain.Course;
import com.yinghao.service.CourseServiceInter;
import com.yinghao.util.WxMessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenyinghao on 2019/9/18.
 */
@Service
@Transactional
public class CourseService extends BaseService<Course> implements CourseServiceInter {
    @Value("${wechat.appid}")
    private String appId;

    @Value("${wechat.appsecret}")
    private String appsecret;

    @Value("${wechat.template.message.course.id}")
    private String courseTemplateId;

    private static final Logger logger = LoggerFactory.getLogger(CourseService.class);

    @Autowired
    private CourseMapper courseMapper;

    @Override
    @Scheduled(cron = "*/20 * * * * *")
    public void sendCourseTask() {
        List<Course> courses = courseMapper.selectAll();
        for (Course course : courses) {
            Map<String, String> content = new HashMap<>();
            content.put("course", course.getCourseName());
            content.put("teacher", course.getTeacher());
            content.put("begin", course.getBeginTime().toString());
            content.put("end", course.getEndTime().toString());
            content.put("address", course.getClassroom());
            WxMessageUtil.sendTemplateMsg(content, courseTemplateId, course.getUserOpenId(), appId, appsecret);
        }
        logger.info("{}: send class.", System.currentTimeMillis());
    }
}
