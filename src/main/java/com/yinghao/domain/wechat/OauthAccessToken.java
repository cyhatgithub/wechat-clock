package com.yinghao.domain.wechat;

/**
 * oauth网页授权获取用户数据
 *
 * Created by chenyinghao on 2017/12/21.
 */
public class OauthAccessToken extends AccessToken{
    private String refresh_token;
    private String openid;
    private String scope;

    public String getRefresh_token() { return refresh_token; }
    public void setRefresh_token(String refresh_token) { this.refresh_token = refresh_token; }

    public String getOpenid() { return openid; }
    public void setOpenid(String openid) { this.openid = openid; }

    public String getScope() { return scope; }
    public void setScope(String scope) { this.scope = scope; }

    public OauthAccessToken() {}

    public OauthAccessToken(String access_token, int expires_in, String refresh_token, String openid, String scope) {
        super(access_token, expires_in);
        this.refresh_token = refresh_token;
        this.openid = openid;
        this.scope = scope;
    }
}
