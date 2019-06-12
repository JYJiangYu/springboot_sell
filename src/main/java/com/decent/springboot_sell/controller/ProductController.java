package com.decent.springboot_sell.controller;


import com.decent.springboot_sell.entity.ProductInfo;
import com.decent.springboot_sell.entity.User;
import com.decent.springboot_sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author jiangyu
 * @date 2019/6/9 14:21
 * @email jiangyu9633@foxmail.com
 */
@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("")
    public String index() {
        return "index";
    }


    @RequestMapping("findAllProduct")
    public Page findAllProduct() {
        return productService.findAll(new PageRequest(0, 2));
    }


}