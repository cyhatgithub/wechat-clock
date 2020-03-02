package com.yinghao.service.impl;

import com.yinghao.dao.CourseDetailMapper;
import com.yinghao.dao.TermMapper;
import com.yinghao.dao.UserMapper;
import com.yinghao.domain.Term;
import com.yinghao.domain.User;
import com.yinghao.domain.wechat.req.UserEventMessage;
import com.yinghao.domain.wechat.req.UserTextMessage;
import com.yinghao.domain.wechat.resp.TextMessage;
import com.yinghao.service.WechatServiceInter;
import com.yinghao.util.WxConstants;
import com.yinghao.util.WxMessageUtil;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by chenyinghao on 2019/9/6.
 */
@Service("wechatService")
public class WechatService implements WechatServiceInter {

    private static final Logger logger = LoggerFactory.getLogger(WechatService.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TermMapper termMapper;

    @Autowired
    private CourseDetailMapper courseDetailMapper;

    @Override
    public String processRequest(HttpServletRequest request) throws IOException,DocumentException {
        String respContent = WxConstants.MESG_ERROR_DEFAULT;
        Map<String, String> params = WxMessageUtil.parseXml(request);
        String fromUserName = params.get(WxConstants.FROM_USER_NAME);
        String toUserName = params.get(WxConstants.TO_USER_NAME);
        String msgType = params.get(WxConstants.MSG_TYPE);
        long createTime = Long.valueOf(params.get(WxConstants.CREATE_TIME));

        // 回复文本消息 暂定
        TextMessage respTextMessage = new TextMessage(
                fromUserName,
                toUserName,
                new Date().getTime(),
                WxConstants.RESP_MESSAGE_TYPE_TEXT,
                0);
        try {
            switch (msgType){
                case WxConstants.REQ_MESSAGE_TYPE_TEXT:
                    String content = params.get(WxConstants.CONTENT);
                    long msgId = Long.valueOf(params.get(WxConstants.MSG_ID));
                    UserTextMessage userTextMessage = new UserTextMessage(
                            toUserName,
                            fromUserName,
                            createTime,
                            msgType,
                            msgId,
                            content
                    );
                    respContent = handleTextReq(userTextMessage);
                    break;
                case WxConstants.REQ_MESSAGE_TYPE_IMAGE:
                    handleImageReq();
                    break;
                case WxConstants.REQ_MESSAGE_TYPE_LOCATION:
                    handleLocationReq();
                    break;
                case WxConstants.REQ_MESSAGE_TYPE_LINK:
                    handleLinkReq();
                    break;
                case WxConstants.REQ_MESSAGE_TYPE_VOICE:
                    handleVoiceReq();
                    break;
                case WxConstants.REQ_MESSAGE_TYPE_EVENT:
                    String eventType = params.get(WxConstants.EVENT_TYPE);
                    String eventKey = params.get(WxConstants.EVENT_KEY);
                    UserEventMessage userEventMessage = new UserEventMessage(
                            toUserName,
                            fromUserName,
                            createTime,
                            msgType,
                            eventType,
                            eventKey
                    );
                    respContent = handleEventReq(userEventMessage);
                    break;

            }
        }catch (IOException e) {
            logger.error("Wechat: request fail user {}, msgType {}", fromUserName, msgType);
        }

        respTextMessage.setContent(respContent);
        return WxMessageUtil.textMessageToXml(respTextMessage);
    }

    @Override
    public String handleWxMessage(HttpServletRequest request) {
        return null;
    }

    /**
     * 处理用户的文本消息
     *
     * @param userTextMessage
     * @return
     * @throws IOException
     */
    public String handleTextReq(UserTextMessage userTextMessage) {
        String content = userTextMessage.getContent();
        String respContent = WxConstants.MESG_ERROR_DEFAULT;
        String openId = userTextMessage.getFromUserName();
        if (content.equals("DXXI")) {
            logger.info("Wechat: user subsribe, openid {}, time {}", userTextMessage.getFromUserName(), userTextMessage.getCreateTime());
            respContent = isBindingOrNot(openId) ? WxConstants.MESG_BINDING_ALREADY:WxConstants.MESG_SUBCRIBE_LEAD;
        } else if (content.startsWith("BD")) {
            //  判断是否已经绑定
            if (isBindingOrNot(openId)) {
                return WxConstants.MESG_BINDING_ALREADY;
            }

            respContent = WxConstants.MESG_BINDING_ERROR;
            String[] BDs = content.split("\\*");
            if (BDs.length == 3) {
                //  查询学期信息
                Term searchCondition = new Term();
                searchCondition.setSchoolName(BDs[2]);
                Term term = termMapper.selectOne(searchCondition);

                if (term != null) {
                    //  插入用户
                    User user = new User();
                    user.setName(BDs[1]);
                    user.setOpenid(userTextMessage.getFromUserName());
                    userMapper.insert(user);
                    int term1Id = term.getId();
                    courseDetailMapper.updateUserIdByTermId(userTextMessage.getFromUserName(), term1Id);
                    respContent = WxConstants.MESG_BINDING_SUCCESS;
                }
            }
        }
        return respContent;
    }
    //  处理用户的图片消息
    public static void handleImageReq() {}

    //  处理用户的地理位置消息
    public static void handleLocationReq() {}

    //  处理用户的链接信息
    public static void handleLinkReq() {}

    //  处理用户的声音消息
    public static void handleVoiceReq() {}

    /**
     * 处理用户的事件消息
     * @param userEventMessage
     */
    public static String handleEventReq(UserEventMessage userEventMessage) throws IOException{
        String openId = userEventMessage.getFromUserName();
        String eventType = userEventMessage.getEvent();
        String respContent = WxConstants.MESG_ERROR_DEFAULT;

        if (eventType.equals(WxConstants.EVENT_TYPE_SUBSCRIBE)) {
            //  订阅事件
            logger.info("Wechat: user subsribe, openid {}, time {}", userEventMessage.getFromUserName(), userEventMessage.getCreateTime());
            respContent = WxConstants.MESG_WELCOME;

        }
        return respContent;
    }

    public boolean isBindingOrNot(String openId) {
        if (openId != null && !openId.equals("")) {
            User user = new User();
            user.setOpenid(openId);
            List<User> users = userMapper.select(user);
            if (users != null && users.size() > 0) {
                return true;
            }
        }
        return false;
    }
}
