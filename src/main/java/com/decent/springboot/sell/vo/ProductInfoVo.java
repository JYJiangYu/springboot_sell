package com.decent.springboot.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author jiangyu
 * @date 2019/6/12 21:28
 * @email jiangyu9633@foxmail.com
 */
@Data
public class ProductInfoVo implements Serializable {

    private static final long serialVersionUID = -4889187251138673064L;
    @JsonProperty("id")
    private String productId;
    @JsonProperty("name")
    private String productName;
    @JsonProperty("price")
    private BigDecimal productPrice;
    @JsonProperty("description")
    private String productDescription;
    @JsonProperty("icon")
    private String productIcon;
}