package com.decent.springboot.sell.service;

import com.decent.springboot.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    public Page<ProductInfo> findAll(Pageable pageable);
}
