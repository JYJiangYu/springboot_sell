package com.decent.springboot_sell.repository;

import com.decent.springboot_sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jiangyu
 * @date 2019/5/30 17:14
 * @email jiangyu9633@foxmail.com
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
}