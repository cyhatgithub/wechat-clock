package com.yinghao.domain.wechat.resp;

import java.util.List;

/**
 * 模板消息
 *
 * Created by chenyinghao on 2017/11/24.
 */
public class Template {

    private String toUser;// 消息接收方
    private String templateId;// 模板id
    private String url;// 模板消息详情链接
    private String topColor;// 消息顶部的颜色
    private List<TemplateParam> templateParamList;// 参数列表

    public String getToUser() { return toUser; }
    public void setToUser(String toUser) { this.toUser = toUser; }

    public String getTemplateId() { return templateId; }
    public void setTemplateId(String templateId) { this.templateId = templateId; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getTopColor() { return topColor; }
    public void setTopColor(String topColor) { this.topColor = topColor; }

    public String toJSON() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        buffer.append(String.format("\"touser\":\"%s\"", this.toUser)).append(",");
        buffer.append(String.format("\"template_id\":\"%s\"", this.templateId)).append(",");
        buffer.append(String.format("\"url\":\"%s\"", this.url)).append(",");
        buffer.append(String.format("\"topcolor\":\"%s\"", this.topColor)).append(",");
        buffer.append("\"data\":{");
        TemplateParam param = null;
        for (int i = 0; i < this.templateParamList.size(); i++) {
            param = templateParamList.get(i);
            // 判断是否追加逗号
            if (i < this.templateParamList.size() - 1){

                buffer.append(String.format("\"%s\": {\"value\":\"%s\",\"color\":\"%s\"},", param.getName(), param.getValue(), param.getColor()));
            }else{
                buffer.append(String.format("\"%s\": {\"value\":\"%s\",\"color\":\"%s\"}", param.getName(), param.getValue(), param.getColor()));
            }

        }
        buffer.append("}");
        buffer.append("}");
        return buffer.toString();
    }

    public List<TemplateParam> getTemplateParamList() { return templateParamList; }

    public void setTemplateParamList(List<TemplateParam> templateParamList) { this.templateParamList = templateParamList; }

}
