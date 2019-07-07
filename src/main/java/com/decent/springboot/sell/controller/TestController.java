package com.decent.springboot.sell.controller;


import com.decent.springboot.sell.entity.User;
import com.decent.springboot.sell.entity.ProductInfo;
import com.decent.springboot.sell.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author jiangyu
 * @date 2019/6/9 14:21
 * @email jiangyu9633@foxmail.com
 */
@Controller
public class TestController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("")
    public String index() {
        return "index";
    }

    @RequestMapping("testMySQL/{id}")
    @ResponseBody
    public ProductInfo testMySQL(@PathVariable String id) {
        return productRepository.findById(id).orElseGet(() -> ProductInfo.builder().productName("暂无产品信息!").build());
    }


    @RequestMapping("optStringRedis/{redisInfo}")
    @ResponseBody
    public String saveStringRedisInfo(@PathVariable String redisInfo) {
        System.out.println(redisInfo);
        if (redisInfo.contains("=")) {
            String[] redisInfoArray = redisInfo.split("=");
            stringRedisTemplate.opsForValue().set(redisInfoArray[0], redisInfoArray[1]);
            System.out.println(Arrays.toString(redisInfoArray));
            return "Operation Is OK !";
        }
        return Optional.ofNullable(stringRedisTemplate.opsForValue().get(redisInfo)).orElse("为空哦~~~");
    }


    @RequestMapping("optObjectRedis")
    @ResponseBody
    public String saveObjectRedisInfo() {
        User user = User.builder().id("1").username("姜禹").age(9999).build();
        System.out.println(user);
        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));
        System.out.println(((User) redisTemplate.opsForValue().get("user")));
        return "Operation Is OK !";
    }


    @GetMapping("setCookie")
    @ResponseBody
    public String setCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("name", "jiangyu");
        cookie.setPath("/");
        cookie.setMaxAge(15);
        response.addCookie(cookie);
        return "Operation Is OK !";
    }

}