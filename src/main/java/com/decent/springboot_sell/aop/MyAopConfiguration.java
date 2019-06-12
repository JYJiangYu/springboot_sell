package com.decent.springboot_sell.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author jiangyu
 * @date 2019/6/12 22:15
 * @email jiangyu9633@foxmail.com
 */
@Component
@Aspect
@Slf4j
public class MyAopConfiguration {

    @Pointcut("execution( * com.decent.springboot_sell.controller..*.*(..) )")
    public void pointCutMethod() {

    }

    @Before("pointCutMethod()()")
    public void beforeMethod(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        log.info("url = {}", attributes.getRequest().getRequestURL());
        log.info("method = {}", attributes.getRequest().getMethod());
        //log.info("ip = {}", attributes.getRequest().getRemoteAddr());
        //log.info("class_method = {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }
}