package com.yinghao.domain.wechat.req;

/**
 * 时间消息
 *
 * Created by chenyinghao on 2017/11/28.
 */
public class UserEventMessage extends UserBaseMessage {
    private String event;
    private String eventKey;

    public String getEvent() { return event; }
    public void setEvent(String event) { this.event = event; }

    public String getEventKey() { return eventKey; }
    public void setEventKey(String eventKey) { this.eventKey = eventKey; }

    // default
    public UserEventMessage() {}

    public UserEventMessage(String toUserName, String fromUserName, long createTime, String msgType, String event, String eventKey) {
        super(toUserName, fromUserName, createTime, msgType);
        this.event = event;
        this.eventKey = eventKey;
    }
}
