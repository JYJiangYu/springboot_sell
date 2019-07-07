package com.decent.springboot.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author jiangyu
 * @date 2019/6/26 23:10
 * @email jiangyu9633@foxmail.com
 */
@Slf4j
@Component
@ServerEndpoint("/websocket")
public class WebSocketImpl {
    private Session session;

    private static CopyOnWriteArrayList<WebSocketImpl> set = new CopyOnWriteArrayList<>();

    @OnOpen
    public void openConn(Session session) {
        this.session = session;
        set.add(this);
        log.info("建立连接..", "set大小为", set.size());
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("收到客户端传来的消息..", message);
    }


    @OnClose
    public void closeConn(Session session) {
        set.remove(this);
        log.info("连接关闭..", "set大小为", set.size(), "session = ", session);
    }

    public void sendMessage(String message) throws IOException {
        for (WebSocketImpl webSocket : set) {
            webSocket.session.getBasicRemote().sendText(message);
        }

    }


}