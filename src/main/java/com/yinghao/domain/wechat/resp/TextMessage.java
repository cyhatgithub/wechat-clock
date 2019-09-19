package com.yinghao.domain.wechat.resp;

/**
 * 文本消息
 *
 * Created by chenyinghao on 2017/11/22.
 */
public class TextMessage extends PlatformBaseMessage {

    private String Content;// 回复的消息内容

    public String getContent() {
        return Content;
    }
    public void setContent(String content) {
        this.Content = content;
    }

    public TextMessage(
            String toUserName,
            String fromUserName,
            long createTime,
            String msgType,
            int funcFlag) {

        super(toUserName, fromUserName, createTime, msgType, funcFlag);
    }

    public TextMessage(
            String toUserName,
            String fromUserName,
            long createTime,
            String msgType,
            int funcFlag,
            String Content) {

        super(toUserName, fromUserName, createTime, msgType, funcFlag);
        this.Content = Content;
    }
}
