package com.decent.springboot_sell.service;

import com.decent.springboot_sell.entity.ProductCategory;
import com.decent.springboot_sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    public Page<ProductInfo> findAll(Pageable pageable);
}
