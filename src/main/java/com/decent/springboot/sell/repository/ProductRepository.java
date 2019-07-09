package com.decent.springboot.sell.repository;

import com.decent.springboot.sell.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author jiangyu
 * @date 2019/5/30 17:14
 * @email jiangyu9633@foxmail.com
 */
public interface ProductRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer status);

    ProductInfo findByProductId(String i);

    //Page<ProductInfo> findAll(Pageable pageable);


}