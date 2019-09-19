package com.yinghao.domain.wechat.req;

/**
 * 链接消息
 *
 * Created by chenyinghao on 2017/11/22.
 */
public class UserLinkMessage extends UserBaseMessage {
    // 消息标题
    private String Title;
    // 消息描述
    private String Description;
    // 消息链接
    private String Url;

    public String getTitle() { return Title; }
    public void setTitle(String title) { Title = title; }

    public String getDescription() { return Description; }
    public void setDescription(String description) { Description = description; }

    public String getUrl() { return Url; }
    public void setUrl(String url) { Url = url; }
}
