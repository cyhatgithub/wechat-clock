package com.yinghao.service;

import org.dom4j.DocumentException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by chenyinghao on 2019/9/6.
 */
public interface WechatServiceInter {
    String processRequest(HttpServletRequest request) throws IOException, DocumentException;

    String handleWxMessage(HttpServletRequest request);
}
