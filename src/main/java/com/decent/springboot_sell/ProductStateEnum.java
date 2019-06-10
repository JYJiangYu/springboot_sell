package com.decent.springboot_sell;

import lombok.Getter;

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
        System.out.println(ProductStateEnum.UP);
        System.out.println(ProductStateEnum.UP.getCode());
        System.out.println(ProductStateEnum.UP.getMessage());
    }

}
