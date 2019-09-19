package com.yinghao.domain.wechat.menu;
/**
 * view类型的菜单
 *
 * Created by chenyinghao on 2017/11/23.
 */
public class MediaButton extends Button {
    private String type;
    private String media_id;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getMedia_id() { return media_id; }
    public void setMedia_id(String media_id) { this.media_id = media_id; }
}
