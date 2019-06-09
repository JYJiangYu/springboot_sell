package com.decent.springboot_sell.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jiangyu
 * @date 2019/6/9 15:53
 * @email jiangyu9633@foxmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
    private String id;
    private String username;
    private Integer age;
}