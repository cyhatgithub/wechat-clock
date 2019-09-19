package com.yinghao.domain.wechat.req;

/**
 * 文本消息
 *
 * Created by chenyinghao on 2017/11/22.
 */
public class UserTextMessage extends UserBaseMessage {

    private String Content;// 消息内容

    public String getContent() {
        return Content;
    }
    public void setContent(String content) {
        Content = content;
    }

    public UserTextMessage(
            String toUserName,
            String fromUserName,
            long createTime,
            String msgType,
            long msgId,
            String content) {

        super(toUserName, fromUserName, createTime, msgType, msgId);
        Content = content;
    }
}
