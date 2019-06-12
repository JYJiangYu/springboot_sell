package com.decent.springboot_sell.vo;

import lombok.Data;

/**
 * @author jiangyu
 * @date 2019/6/12 21:19
 * @email jiangyu9633@foxmail.com
 */
@Data
public class ProductResultVo<T> {
    private Integer code;
    private String message;
    private T data;
}