package com.yinghao.service.impl;

import com.yinghao.domain.wechat.req.UserEventMessage;
import com.yinghao.domain.wechat.req.UserTextMessage;
import com.yinghao.domain.wechat.resp.TextMessage;
import com.yinghao.service.WechatServiceInter;
import com.yinghao.util.WxConstants;
import com.yinghao.util.WxMessageUtil;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * Created by chenyinghao on 2019/9/6.
 */
@Service("wechatService")
public class WechatService implements WechatServiceInter {

    private static final Logger logger = LoggerFactory.getLogger(WechatService.class);

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
    public static String handleTextReq(UserTextMessage userTextMessage) {
        return "";
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

}
