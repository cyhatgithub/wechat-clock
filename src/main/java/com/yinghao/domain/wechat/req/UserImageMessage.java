package com.yinghao.domain.wechat.req;

/**
 * 图片消息
 *
 * Created by chenyinghao on 2017/11/22.
 */
public class UserImageMessage extends UserBaseMessage {
    // 图片链接
    private String PicUrl;

    public String getPicUrl() { return PicUrl; }
    public void setPicUrl(String picUrl) { PicUrl = picUrl; }
}
