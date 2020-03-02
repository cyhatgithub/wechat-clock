//package com.yinghao.service.impl;
//
//import com.yinghao.dao.CourseDetailMapper;
//import com.yinghao.dao.CourseMapper;
//import com.yinghao.domain.Course;
//import com.yinghao.service.CourseServiceInter;
//import com.yinghao.util.DateUtil;
//import com.yinghao.util.WxConstants;
//import com.yinghao.util.WxMessageUtil;
//import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.*;
//
///**
// * Created by chenyinghao on 2019/9/18.
// */
//@Service
//@Transactional
//public class CourseService extends BaseService<Course> implements CourseServiceInter {
//    @Value("${wechat.appid}")
//    private String appId;
//
//    @Value("${wechat.appsecret}")
//    private String appsecret;
//
//    @Value("${wechat.template.message.course.id}")
//    private String courseTemplateId;
//
//    @Value("${notification.normal.minutes:60}")
//    private int normalMins;
//
//    @Value("${notification.warn.minutes:30}")
//    private int warnMins;
//
//    @Value("${notification.crit.minutes:10}")
//    private int critMins;
//
//    private static final Logger logger = LoggerFactory.getLogger(CourseService.class);
//
//    @Autowired
//    private CourseMapper courseMapper;
//
//    @Autowired
//    private CourseDetailMapper courseDetailMapper;
//
//    @Override
//    @Scheduled(cron = "*/20 * * * * *")
//    public void sendCourseTask() {
////        List<Course> courses = courseMapper.selectAll();
////        checkAndSend(courses);
////        logger.info("{}: send class.", System.currentTimeMillis());
//    }
//
//    /**
//     * 检验课程是否需要发送
//     * @param courses
//     * @return
//     */
//    private void checkAndSend(List<Course> courses) {
//        if (courses != null) {
//            Date now = new Date();
//            String todayWeek = DateUtil.getWeek();  //  得到今天周几
//
//            for (Course course : courses) {
//                Date startDate = course.getStartTime(); //  开始上课时间
//                Date beginDate = course.getBeginTime(); //  课程开始时间
//                long beginMs = beginDate.getTime();
//                long curMs = System.currentTimeMillis();
//                String startStr = DateUtil.dateFormat(startDate);
//                String courseWeek = DateUtil.getWeek(startStr); //  课程周几上
//
//                if (curMs > beginMs && courseWeek.equals(todayWeek)) {
//                    int diffHours = startDate.getHours() - now.getHours();
//                    int diffMinutes = startDate.getMinutes() - now.getMinutes();
//                    int diffSecond = startDate.getSeconds() - now.getSeconds();
//                    int diffMs = diffHours * 60 * 60 * 1000 + diffMinutes * 60 * 1000 + diffSecond * 1000;
//                    if (diffMs < normalMins * 60 * 1000 && diffMs > 0) {
//                        List<WxMpTemplateData> msg = generateMsg(course, diffMs);
//                        WxMessageUtil.sendTemplateMsg(msg, courseTemplateId, course.getUserOpenId(), appId, appsecret);
//                    }
//                }
//            }
//        }
//    }
//
//    private List<WxMpTemplateData> generateMsg(Course course, long diffMs) {
//        List<WxMpTemplateData> wxMpTemplateDatas = new ArrayList<>();
////        Map<String, String> msg = new HashMap<>();
//        Date start = course.getStartTime();
//        Date end = course.getEndTime();
//        String startStr = DateUtil.dateFormat(start);
//        String endStr = DateUtil.dateFormat(end);
//
//        wxMpTemplateDatas.add(new WxMpTemplateData(WxConstants.HEAD, "小钟有一门课程即将开始!"));
//        wxMpTemplateDatas.add(new WxMpTemplateData(WxConstants.COURSE, course.getCourseName()));
//        wxMpTemplateDatas.add(new WxMpTemplateData(WxConstants.CLASS_BEGIN_TIME, startStr));
//        wxMpTemplateDatas.add(new WxMpTemplateData(WxConstants.CLASS_END_TIME, endStr));
//        wxMpTemplateDatas.add(new WxMpTemplateData(WxConstants.ADDRESS, course.getClassroom()));
//
//        String remarkHead = String.format("距离上课还有%s分钟!", diffMs/(60 * 1000));
//        if (diffMs < critMins * 60 * 1000) {
//            wxMpTemplateDatas.add(new WxMpTemplateData(WxConstants.REMARK, remarkHead, "#FF0000"));
//
//        } else if (diffMs < warnMins * 60 * 1000) {
//            wxMpTemplateDatas.add(new WxMpTemplateData(WxConstants.REMARK, remarkHead, "#FFA500"));
//
//        } else {
//            wxMpTemplateDatas.add(new WxMpTemplateData(WxConstants.REMARK, remarkHead, "#32CD32"));
//        }
//        return wxMpTemplateDatas;
//    }
//}
