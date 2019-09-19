package com.yinghao.domain.wechat.resp;

/**
 * 模板消息参数
 *
 * Created by chenyinghao on 2017/11/24.
 */
public class TemplateParam {

    private String name;// 参数名称
    private String value;// 参数值
    private String color;// 颜色

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public TemplateParam(String name,String value,String color){
        this.name=name;
        this.value=value;
        this.color=color;
    }

}
