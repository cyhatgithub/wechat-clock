package com.yinghao.controller;

import com.yinghao.service.CourseServiceInter;
import com.yinghao.service.WechatServiceInter;
import com.yinghao.util.WxSignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by chenyinghao on 2019/9/6.
 */

@RestController
@RequestMapping(value = "/wechat")
public class WechatController {
    @Value("${wechat.token}")
    private String WECHAT_TOKEN;

    @Autowired
    WechatServiceInter wechatService;
    @Autowired
    CourseServiceInter courseService;

    private static final Logger logger = LoggerFactory.getLogger(WechatController.class);

    @RequestMapping(value = "/core", method = {RequestMethod.GET, RequestMethod.POST})
    public void coreProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //  防止中文请求乱码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        boolean isGet = request.getMethod().toLowerCase().equals("get");
        PrintWriter printWriter = response.getWriter();
        try {
            if (isGet) {
                String signature = request.getParameter("signature");// 微信加密签名
                String timestamp = request.getParameter("timestamp");// 时间戳
                String nonce = request.getParameter("nonce");// 随机数
                String echostr = request.getParameter("echostr");//随机字符串

                if (WxSignUtil.checkSignature("yinghao", signature, timestamp, nonce)) {
                    logger.info("Success to connect wechat server.");
                    printWriter.write(echostr);
                } else {
                    logger.error("Failed to verify the signature.");
                }
            } else {
                String respMsg = "异常消息";
                try {
                    respMsg = wechatService.processRequest(request);
                    printWriter.write(respMsg);
                    logger.info("Successful to response wechat message: {}.", respMsg);
                } catch (Exception e) {
                    logger.error("Failed to convert the message from weixin.");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }

    }
}
