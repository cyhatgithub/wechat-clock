package com.yinghao.service.impl;

import com.yinghao.dao.CourseMapper;
import com.yinghao.domain.Course;
import com.yinghao.service.CourseServiceInter;
import com.yinghao.util.DateUtil;
import com.yinghao.util.WxConstants;
import com.yinghao.util.WxMessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
        checkAndSend(courses);
        logger.info("{}: send class.", System.currentTimeMillis());
    }

    /**
     * 检验课程是否需要发送
     * @param courses
     * @return
     */
    private void checkAndSend(List<Course> courses) {
        if (courses != null) {
            Date now = new Date();
            String todayWeek = DateUtil.getWeek();  //  得到今天周几

            for (Course course : courses) {
                Date startDate = course.getStartTime(); //  开始上课时间
                Date beginDate = course.getBeginTime(); //  课程开始时间
                long beginMs = beginDate.getTime();
                long curMs = System.currentTimeMillis();
                String startStr = DateUtil.dateFormat(startDate);
                String courseWeek = DateUtil.getWeek(startStr); //  课程周几上

                if (curMs > beginMs && courseWeek.equals(todayWeek)) {
                    int diffHours = startDate.getHours() - now.getHours();
                    int diffMinutes = startDate.getMinutes() - now.getMinutes();
                    int diffSecond = startDate.getSeconds() - now.getSeconds();
                    int diffMs = diffHours * 60 * 60 * 1000 + diffMinutes * 60 * 1000 + diffSecond * 1000;
                    if (diffMs < 60 * 60 * 1000 && diffMs > 0) {
                        Map<String, String> msg = generateMsg(course, diffMs);
                        WxMessageUtil.sendTemplateMsg(msg, courseTemplateId, course.getUserOpenId(), appId, appsecret);
                    }
                }
            }
        }
    }

    private Map<String, String> generateMsg(Course course, long diffMs) {
        Map<String, String> msg = new HashMap<>();
        msg.put(WxConstants.COURSE, course.getCourseName());
        Date start = course.getStartTime();
        Date end = course.getEndTime();
        String startStr = DateUtil.dateFormat(start);
        String endStr = DateUtil.dateFormat(end);
        msg.put(WxConstants.CLASS_BEGIN_TIME, startStr);
        msg.put(WxConstants.CLASS_END_TIME, endStr);
        msg.put(WxConstants.ADDRESS, course.getClassroom());
        if (diffMs < 10 * 60 * 1000) {
            msg.put(WxConstants.REMARK, "距离上课还有不到十分钟.");
        } else if (diffMs < 10 * 60 * 1000) {
            msg.put(WxConstants.REMARK, "距离上课还有不到三十分钟.");
        } else {
            msg.put(WxConstants.REMARK, "距离上课还有不到六十分钟.");
        }
        return msg;
    }
}
