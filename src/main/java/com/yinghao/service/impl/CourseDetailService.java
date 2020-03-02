package com.yinghao.service.impl;

import com.yinghao.dao.CourseDetailMapper;
import com.yinghao.domain.CourseDetail;
import com.yinghao.domain.Term;
import com.yinghao.service.CourseDetailServiceInter;
import com.yinghao.util.DateUtil;
import com.yinghao.util.WxConstants;
import com.yinghao.util.WxMessageUtil;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CourseDetailService implements CourseDetailServiceInter {

    @Value("${wechat.appid}")
    private String appId;

    @Value("${wechat.appsecret}")
    private String appsecret;

    @Value("${wechat.template.message.course.id}")
    private String courseTemplateId;

    @Value("${notification.normal.minutes:60}")
    private int normalMins;

    @Value("${notification.warn.minutes:30}")
    private int warnMins;

    @Value("${notification.crit.minutes:10}")
    private int critMins;

    private static final Logger logger = LoggerFactory.getLogger(CourseDetailService.class);

    @Autowired
    private CourseDetailMapper courseDetailMapper;

    @Override
    @Scheduled(cron = "0 */1 * * * ?")
    public void sendCourseTask() {
        List<CourseDetail> courseDetails = courseDetailMapper.selectAllWithTerm();
        checkAndSend(courseDetails);
        logger.info("{}: send class.", System.currentTimeMillis());
    }

    /**
     * 检验课程是否需要发送
     * @param courses
     * @return
     */
    private void checkAndSend(List<CourseDetail> courses) {
        if (courses != null) {
            Date now = new Date();
            String todayWeekDay = DateUtil.getWeek();  //  得到今天周几
            //  得到当前是第几周
            //  然后看本周是否是规定的上课时间内
            for (CourseDetail course : courses) {

                int todayWeek = getTodayWeek(now, course);
                //  判断今天是否上课
                if (shouldHaveClassDay(course, todayWeek, todayWeekDay)) {
                    Date courseStartTime = course.getStartTime();
                    int diffHours = courseStartTime.getHours() - now.getHours();
                    int diffMinutes = courseStartTime.getMinutes() - now.getMinutes();
                    int diffSecond = courseStartTime.getSeconds() - now.getSeconds();
                    int diffMs = diffHours * 60 * 60 * 1000 + diffMinutes * 60 * 1000 + diffSecond * 1000;
                    if (diffMs < normalMins * 60 * 1000 && diffMs > 0) {
                        List<WxMpTemplateData> msg = generateMsg(course, diffMs);
                        WxMessageUtil.sendTemplateMsg(msg, courseTemplateId, course.getUserId(), appId, appsecret);
                    }
                }
            }
        }
    }

    /**
     * 判断今天是否上课
     *  1.todayWeek小于等于course_end_week
     *  2.class_model,0:每周上，1：单周上，2：双周上
     * @param course
     * @param todayWeek
     * @return
     */
    private boolean shouldHaveClassDay(CourseDetail course, int todayWeek, String todayWeekDay) {
        if (course != null) {
            int courseEndWeek = course.getCourseEndWeek();
            int classModel = course.getClassModel();
            String classWeekDay = course.getWeekDay();
            boolean isSingle = (todayWeek%2 == 0);
            if (todayWeek <= courseEndWeek && (classModel == 0 || (classModel == 1 && isSingle) || (classModel == 2 && !isSingle)) && todayWeekDay.equals(classWeekDay)) {
                return true;
            }
        }
        return false;
    }

    private int getTodayWeek(Date now, CourseDetail course) {
        Term term = course.getTerm();
        //  得到第一周周一的具体日期
        String firstWeekDate = DateUtil.getWeek(
                DateUtil.dateFormat(term.getTermBeginTime()),
                "1"
        );

        //  计算当前时间是第几周,并且判断是否在上课周次之内
        int diffDays = DateUtil.getDiffDays(DateUtil.strToDate(firstWeekDate), now);
        int todayWeek = diffDays / 7 + 1;
        return todayWeek;
    }

    private List<WxMpTemplateData> generateMsg(CourseDetail course, long diffMs) {
        List<WxMpTemplateData> wxMpTemplateDatas = new ArrayList<>();
//        Map<String, String> msg = new HashMap<>();
        Date start = course.getStartTime();
        Date end = course.getEndTime();
        String startStr = DateUtil.dateFormat2(start);
        String endStr = DateUtil.dateFormat2(end);

        wxMpTemplateDatas.add(new WxMpTemplateData(WxConstants.HEAD, "有一门课程即将开始!"));
        wxMpTemplateDatas.add(new WxMpTemplateData(WxConstants.COURSE, course.getCourseName()));
        wxMpTemplateDatas.add(new WxMpTemplateData(WxConstants.CLASS_BEGIN_TIME, startStr));
        wxMpTemplateDatas.add(new WxMpTemplateData(WxConstants.CLASS_END_TIME, endStr));
        wxMpTemplateDatas.add(new WxMpTemplateData(WxConstants.ADDRESS, course.getClassRoom()));

        String remarkHead = String.format("距离上课还有%s分钟!", diffMs/(60 * 1000));
        if (diffMs < critMins * 60 * 1000) {
            wxMpTemplateDatas.add(new WxMpTemplateData(WxConstants.REMARK, remarkHead, "#FF0000"));

        } else if (diffMs < warnMins * 60 * 1000) {
            wxMpTemplateDatas.add(new WxMpTemplateData(WxConstants.REMARK, remarkHead, "#FFA500"));

        } else {
            wxMpTemplateDatas.add(new WxMpTemplateData(WxConstants.REMARK, remarkHead, "#32CD32"));
        }
        return wxMpTemplateDatas;
    }
}
