package com.decent.springboot_sell;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ProductStateEnum {
    UP(0, "上架"),
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
        System.out.println(theLong == Long.valueOf(theInt));
    }

}
