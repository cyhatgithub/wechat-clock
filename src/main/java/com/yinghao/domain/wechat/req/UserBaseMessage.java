package com.yinghao.domain.wechat.req;

/**
 * 用户消息基类(用户 -> 公众号)
 *
 * Created by chenyinghao on 2017/11/22.
 */
public class UserBaseMessage {

    private String ToUserName;// 开发者微信号

    private String FromUserName;// 发送方帐号（一个OpenID）

    private long CreateTime;// 消息创建时间 （整型）

    private String MsgType;// 消息类型（text/image/location/link）

    private long MsgId;// 消息id，64位整型

    public String getToUserName() { return ToUserName; }
    public void setToUserName(String toUserName) { ToUserName = toUserName; }

    public String getFromUserName() { return FromUserName; }
    public void setFromUserName(String fromUserName) { FromUserName = fromUserName; }

    public long getCreateTime() { return CreateTime; }
    public void setCreateTime(long createTime) { CreateTime = createTime; }

    public String getMsgType() { return MsgType; }
    public void setMsgType(String msgType) { MsgType = msgType; }

    public long getMsgId() { return MsgId; }
    public void setMsgId(long msgId) { MsgId = msgId; }

    //default
    public UserBaseMessage() {}

    public UserBaseMessage(String toUserName, String fromUserName, long createTime, String msgType, long msgId) {
        ToUserName = toUserName;
        FromUserName = fromUserName;
        CreateTime = createTime;
        MsgType = msgType;
        MsgId = msgId;
    }

    public UserBaseMessage(String toUserName, String fromUserName, long createTime, String msgType) {
        ToUserName = toUserName;
        FromUserName = fromUserName;
        CreateTime = createTime;
        MsgType = msgType;
    }
}
