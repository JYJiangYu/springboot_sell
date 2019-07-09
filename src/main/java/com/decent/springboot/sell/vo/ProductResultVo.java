package com.decent.springboot.sell.vo;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author jiangyu
 * @date 2019/6/12 21:19
 * @email jiangyu9633@foxmail.com
 */
@Data
public class ProductResultVo<T> implements Serializable {

    private static final long serialVersionUID = 3761666429866028564L;
    private Integer code;
    private String message;
    private T data;
}