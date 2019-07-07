package com.decent.springboot.sell.service.impl;

import com.decent.springboot.sell.entity.ProductCategory;
import com.decent.springboot.sell.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiangyu
 * @date 2019/5/30 17:18
 * @email jiangyu9633@foxmail.com
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public ProductCategory findOne(Integer categoryId) {

        return null;
    }

    @Override
    public List<ProductCategory> findAll() {
        return null;
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return null;
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return null;
    }
}