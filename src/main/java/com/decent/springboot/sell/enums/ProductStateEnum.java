package com.decent.springboot.sell.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author jiangyu
 */
@Getter
public enum ProductStateEnum {
    /**
     * 商品上架
     */
    UP(0, "上架"),
    /**
     * 商品下架
     */
    DOWN(1, "下架");

    private Integer code;
    private String message;

    ProductStateEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static void main(String[] args) {
        ProductStateEnum[] enumConstants = ProductStateEnum.class.getEnumConstants();
        System.out.println(Arrays.toString(enumConstants));
        Long theLong = 1L;
        Integer theInt = 1;
        System.out.println(theLong.equals(Long.valueOf(theInt)));
    }

}
