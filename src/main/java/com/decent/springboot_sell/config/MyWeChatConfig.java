package com.decent.springboot_sell.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author jiangyu
 * @date 2019/6/25 22:59
 * @email jiangyu9633@foxmail.com
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class MyWeChatConfig {
    private String appId;
    private String appSecret;
}