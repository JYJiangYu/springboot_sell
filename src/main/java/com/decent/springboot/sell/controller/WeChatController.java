package com.decent.springboot.sell.controller;

import com.alibaba.fastjson.JSONObject;
import com.decent.springboot.sell.config.MyWeChatConfig;
import com.decent.springboot.sell.vo.wechatvo.TemplateData;
import com.decent.springboot.sell.vo.wechatvo.TemplateSingleInfoVo;
import com.decent.springboot.sell.vo.wechatvo.WeChatTemplateVo;
import com.decent.springboot.sell.service.WebSocketImpl;
import com.decent.springboot.sell.util.WeChatUtil;
import com.decent.springboot.sell.vo.WeChatUserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * @author jiangyu
 * @date 2019/6/25 22:05
 * @email jiangyu9633@foxmail.com
 */
@Slf4j
@RequestMapping("weChat")
@Controller
public class WeChatController {
    @Autowired
    MyWeChatConfig config;
    @Autowired
    WebSocketImpl webSocket;

    @GetMapping("weChatValidate")
    @ResponseBody
    public String weChatValidate(String signature, String timestamp, String nonce, String echostr) throws NoSuchAlgorithmException {
        log.info("参数为--signature={},timestamp={},nonce={},echostr={},", signature, timestamp, nonce, echostr);
        return WeChatUtil.checkSignature(signature, timestamp, nonce, echostr);
    }

    @GetMapping("testAccessToken")
    @ResponseBody
    public String testAccessToken() {
        return WeChatUtil.getAccessToken();
    }

    @GetMapping("testPushTemplate")
    @ResponseBody
    public String testpushTemplate() throws IOException {
        WeChatTemplateVo weChatTemplateVo = new WeChatTemplateVo();
        weChatTemplateVo.setTemplateId("F1qT1AU4NV8L-4rF_t0Tdw7hFPc2Z40bRfhHNTLBdPs");
        weChatTemplateVo.setTouser("ojmxs1OIMb5xM2Vop6bZlBJ-gS6k");
        TemplateData templateData = new TemplateData();
        templateData.setFirst(new TemplateSingleInfoVo("成功推送消息!", "#87CEFA"));
        templateData.setKeyword1(new TemplateSingleInfoVo("姜禹!", "#00CED1"));
        templateData.setKeyword2(new TemplateSingleInfoVo("23岁!", "#00CED1"));
        templateData.setKeyword3(new TemplateSingleInfoVo("I'M THE NO.1!", "#00CED1"));
        templateData.setRemark(new TemplateSingleInfoVo("继续努力!!!", "#EEAD0E"));
        weChatTemplateVo.setData(templateData);
        WeChatUtil.pushTemplate(weChatTemplateVo);
        webSocket.sendMessage("成功发送模板消息..");
        return "OK";
    }


    @RequestMapping("webGetUserInfoRedirectUrl")
    @ResponseBody
    public WeChatUserInfoVo getUserInfoRedirectUrl(String code) throws IOException {
        JSONObject webAuthAccessToken = WeChatUtil.getWebAuthAccessToken(code);
        WeChatUserInfoVo userInfoVo = WeChatUtil.getUserInfoByWebToken(webAuthAccessToken);
        log.info(userInfoVo.toString());
        return userInfoVo;
    }

}