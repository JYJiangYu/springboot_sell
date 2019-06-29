package com.decent.springboot_sell.util;

import com.alibaba.fastjson.JSONObject;
import com.decent.springboot_sell.vo.wechatvo.WeChatTemplateVo;
import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;

/**
 * @author jiangyu
 * @date 2019/6/25 22:19
 * @email jiangyu9633@foxmail.com
 */
@Slf4j
public class WeChatUtil {

    private static WeChatUtil weChatUtil;
    //过期时间
    private static Long expiresTime;
    //缓存的token
    private static String cacheAccessToken;
    private static final String APP_ID = "wx89bfa4d6cdcbe878";
    private static final String APP_SECRET = "c84cb17133b2b717c8ed4eb6799b5c7e";

    private static final String WX_TOKEN = "JIANGYU_WX_TOKEN";
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    private static final String PUSH_TEMPLATE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";


    public static String getAccessToken() {
        if (expiresTime == null || System.currentTimeMillis() > expiresTime) {
            String jsonResult = HttpUtil.get(ACCESS_TOKEN_URL.replace("APPID", APP_ID).replace("APPSECRET", APP_SECRET));
            JSONObject jsonObject = JSONObject.parseObject(jsonResult);
            cacheAccessToken = jsonObject.getString("access_token");
            Long expiresIn = jsonObject.getLong("expires_in");
            expiresTime = System.currentTimeMillis() + (expiresIn - 1) * 1000;
        }
        log.info("获取access_token :{}", cacheAccessToken);
        return cacheAccessToken;
    }


    public static String pushTemplate(WeChatTemplateVo weChatTemplateVo) {
        String jsonString = JSONObject.toJSONString(weChatTemplateVo);
        String result = HttpUtil.post(PUSH_TEMPLATE_URL.replace("ACCESS_TOKEN", getAccessToken()), jsonString);
        return result;
    }


    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());

    }

    public static String checkSignature(String signature, String timestamp, String nonce, String echostr) throws NoSuchAlgorithmException {
        String[] wxParams = new String[]{WX_TOKEN, timestamp, nonce};
        Arrays.sort(wxParams);
        MessageDigest instance = MessageDigest.getInstance("SHA-1");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < wxParams.length; i++) {
            stringBuilder.append(wxParams[i]);
        }
        byte[] digest = instance.digest(stringBuilder.toString().getBytes());
        String digestStr = byteToStr(digest);
        boolean checkSignatureResult = digestStr != null ? signature.toUpperCase().equals(digestStr) : false;
        if (checkSignatureResult)
            return echostr;
        return "";
    }


    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    public static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    public static String byteToHexStr(byte mByte) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }


}