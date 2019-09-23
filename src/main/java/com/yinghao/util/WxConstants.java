package com.yinghao.util;

/**
 * Created by chenyinghao on 2019/9/6.
 */
public class WxConstants {
    //  wechat's official paths
    public static final String TOKEN_URL        = "https://api.weixin.qq.com/cgi-bin/token";
    public static final String OAUTH_URL         = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
    public static final String MENU_CREATE_URL  = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    public static final String TEMPLATE_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
    public static final String OAUTH_TOKEN_URL  = "https://api.weixin.qq.com/sns/oauth2/access_token";
    //  wechat's response message type
    public static final String RESP_MESSAGE_TYPE_TEXT  = "text";	//响应:文本
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";   //响应:音乐
    public static final String RESP_MESSAGE_TYPE_NEWS  = "news";    //响应:图文

    //  wechat's request message type
    public static final String REQ_MESSAGE_TYPE_TEXT     = "text";//请求:文本
    public static final String REQ_MESSAGE_TYPE_IMAGE    = "image";//请求:图片
    public static final String REQ_MESSAGE_TYPE_LINK     = "link";//请求:链接
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";//请求:地理位置
    public static final String REQ_MESSAGE_TYPE_VOICE    = "voice";//请求:音频
    public static final String REQ_MESSAGE_TYPE_EVENT    = "event";//请求:事件

    //  wechat's request event type
    public static final String EVENT_TYPE_SUBSCRIBE   = "subscribe";//请求:事件:订阅
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";//请求:事件:取消订阅
    public static final String EVENT_TYPE_CLICK       = "CLICK";//请求:事件:菜单点击

    //  wechat's click event type
    public static final String CLICK_KEY_BUNDING     = "1";//点击事件:账号绑定
    public static final String CLICK_KEY_UNBUND      = "2";//点击事件:账号解绑
    public static final String CLICK_KEY_SYSTEM_SCAN = "3";//点击事件:账号解绑

    //  wechat's response message
    public static final String MESG_BUNDING_GUARD     = "EMOJILEFT<a href='URL'>戳我</a>EMOJIRIGHT对当前微信账号进行绑定操作,成功绑定后可以接收系统报警,以及查看系统总览.";
    public static final String MESG_SYSTEM_SCAN_GUARD = "EMOJILEFT<a href='URL'>戳我</a>EMOJIRIGHT查看当前系统总览.";

    public static final String MESG_ALREADY_BUNDING = "当前微信账号已绑定,若需解绑请点击菜单进行操作.";
    public static final String MESG_UNBLIND_SUCCESS = "解绑成功!";
    public static final String MESG_UNBLIND_FAIL    = "解绑失败,您可能还未绑定,EMOJILEFT<a href='URL'>戳我</a>EMOJIRIGHT对当前微信账号进行绑定操作,成功绑定后可以接收系统报警,以及查看系统总览.";

    public static final String MESG_ERROR_DEFAULT = "未支持事件,请重试!";
    public static final String MESG_WELCOME       = "感谢关注云兴维智微信公众平台,携手共建智能运维平台,您可以通过自定义菜单\"系统绑定\"进入绑定页面对当前微信号进行系统绑定,绑定成功后,您可以接收系统报警信息,以及查看系统总览.";

    //  wechat's template message line color
    public static final String MESG_COLOR_RED    = "#FF0000";
    public static final String MESG_COLOR_YELLOW = "#FF9900";
    public static final String MESG_COLOR_BLACK  = "#000000";

    // wechat's request handle result
    public static final boolean REQ_HANDLE_SUCCESS = true;
    public static final boolean REQ_HANDLE_FAIL    = false;

    //  wechat's official url param
    public static final String ECHOSTR   = "echostr";  //微信校验参数:随机字符
    public static final String NONCE     = "nonce";  //微信校验参数:随机数
    public static final String SIGNATURE = "signature";  //微信校验参数:加密签名
    public static final String TIMESTAMP = "timestamp";  //微信校验参数:时间戳

    public static final String APPID          = "APPID";
    public static final String SCOPE          = "SCOPE";
    public static final String REDIRECT_URI   = "REDIRECT_URI";

    //  wechat's url param value
    public static final String GRANT_TYPE_CLIENT_CREDENTIAL  = "client_credential";
    public static final String GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code";
    public static final String SCOPE_SNSAPI_BASE             = "snsapi_base";
    public static final String SCOPE_SNSAPI_USERINFO         = "snsapi_userinfo";

    public static final String NOT_MORE_INFO = "Nan";

    public static final String FROM_USER_NAME = "FromUserName";
    public static final String TO_USER_NAME   = "ToUserName";
    public static final String MSG_TYPE       = "MsgType";
    public static final String CONTENT        = "Content";
    public static final String CREATE_TIME    = "CreateTime";
    public static final String MSG_ID         = "MsgId";
    public static final String EVENT_TYPE     = "Event";
    public static final String EVENT_KEY      = "EventKey";

    public static final String COURSE = "course";   //
    public static final String CLASS_BEGIN_TIME = "begin";
    public static final String CLASS_END_TIME = "end";
    public static final String TEACHER = "teacher";
    public static final String ADDRESS = "address";
    public static final String REMARK = "remark";
    public static final String DIFFMS = "diffMs";
}