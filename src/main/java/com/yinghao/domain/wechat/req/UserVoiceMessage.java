package com.yinghao.domain.wechat.req;

/**
 * 音频消息
 *
 * Created by chenyinghao on 2017/11/22.
 */
public class UserVoiceMessage extends UserBaseMessage {
    // 媒体ID
    private String MediaId;
    // 语音格式
    private String Format;

    public String getMediaId() { return MediaId; }
    public void setMediaId(String mediaId) { MediaId = mediaId; }

    public String getFormat() { return Format; }
    public void setFormat(String format) { Format = format; }
}
