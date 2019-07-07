package com.decent.springboot.sell.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author jiangyu
 * @date 2019/6/26 23:11
 * @email jiangyu9633@foxmail.com
 */
@Configuration
public class MyWebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }


}