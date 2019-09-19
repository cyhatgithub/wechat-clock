package com.yinghao.domain.wechat.menu;

/**
 * view类型的菜单
 *
 * Created by chenyinghao on 2017/11/23.
 */
public class ViewButton extends Button {
    private String type;
    private String url;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
