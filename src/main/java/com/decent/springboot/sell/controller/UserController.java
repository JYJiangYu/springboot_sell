package com.decent.springboot.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author jiangyu
 * @date 2019/6/23 23:10
 * @email jiangyu9633@foxmail.com
 */
@Slf4j
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("login")
    @ResponseBody
    public String login(HttpServletResponse response, HttpSession session) {
        String sessionId = session.getId();
        log.info(sessionId);
        Cookie cookie = new Cookie("JSESSION_ID_".concat(sessionId), sessionId);
        response.addCookie(cookie);
        stringRedisTemplate.opsForValue().set("JSESSION_ID_".concat(sessionId), sessionId);
        return "login";
    }
}