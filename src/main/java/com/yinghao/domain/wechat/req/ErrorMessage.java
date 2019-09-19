package com.yinghao.domain.wechat.req;

/**
 * 微信接口返回消息
 *  1.当errcode == 0 则为成功
 *  2.其他返回码说明,参见 https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1433747234
 *
 * Created by chenyinghao on 2017/11/23.
 */
public class ErrorMessage {
    private Long errcode;   //微信接口返回码
    private String errmsg;  //说明

    public Long getErrcode() { return errcode; }
    public void setErrcode(Long errcode) { this.errcode = errcode; }

    public String getErrmsg() { return errmsg; }

    public void setErrmsg(String errmsg) { this.errmsg = errmsg; }
}
