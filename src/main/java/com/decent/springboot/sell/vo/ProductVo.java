package com.decent.springboot.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author jiangyu
 * @date 2019/6/12 21:29
 * @email jiangyu9633@foxmail.com
 */
@Data
public class ProductVo implements Serializable {

    private static final long serialVersionUID = 2913560469530127634L;
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;
}