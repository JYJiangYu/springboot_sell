package com.decent.springboot_sell.service.impl;

import com.decent.springboot_sell.entity.ProductCategory;
import com.decent.springboot_sell.entity.ProductInfo;
import com.decent.springboot_sell.repository.ProductRepository;
import com.decent.springboot_sell.service.CategoryService;
import com.decent.springboot_sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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