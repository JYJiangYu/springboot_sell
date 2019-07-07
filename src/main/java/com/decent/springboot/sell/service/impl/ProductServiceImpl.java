package com.decent.springboot.sell.service.impl;

import com.decent.springboot.sell.entity.ProductInfo;
import com.decent.springboot.sell.repository.ProductRepository;
import com.decent.springboot.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author jiangyu
 * @date 2019/5/30 17:18
 * @email jiangyu9633@foxmail.com
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository repository;

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}