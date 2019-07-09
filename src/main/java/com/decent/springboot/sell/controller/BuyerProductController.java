package com.decent.springboot.sell.controller;

import com.decent.springboot.sell.vo.ProductInfoVo;
import com.decent.springboot.sell.vo.ProductResultVo;
import com.decent.springboot.sell.vo.ProductVo;
import com.decent.springboot.sell.enums.ProductStateEnum;
import com.decent.springboot.sell.entity.ProductCategory;
import com.decent.springboot.sell.entity.ProductInfo;
import com.decent.springboot.sell.repository.ProductCategoryRepository;
import com.decent.springboot.sell.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiangyu
 * @date 2019/6/12 21:21
 * @email jiangyu9633@foxmail.com
 */
@Slf4j
@RestController
@RequestMapping("/buyer/product")
@CacheConfig(cacheNames = "product")
public class BuyerProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @GetMapping("/list")
    @Cacheable(cacheNames = "product", key = "'productInfoRedis'", unless = "#result.code==0")
    public ProductResultVo getAllProduct() {
        ProductResultVo productResultVo = new ProductResultVo<>();
        List<ProductInfo> productInfoList = productRepository.findAll();
        List<Integer> collect = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> byCategoryTypeIn = productCategoryRepository.findByCategoryTypeIn(collect);
        ArrayList<ProductVo> productVoArrayList = new ArrayList<>();
        for (ProductCategory productCategory : byCategoryTypeIn) {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());
            ArrayList<ProductInfoVo> productInfoVoArrayList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoArrayList.add(productInfoVo);
                }
                productVo.setProductInfoVoList(productInfoVoArrayList);
            }
            productVoArrayList.add(productVo);
        }
        productResultVo.setCode(ProductStateEnum.UP.getCode());
        productResultVo.setMessage("成功");
        productResultVo.setData(productVoArrayList);
        return productResultVo;
    }

    @RequestMapping("updateProduct")
    @CacheEvict(cacheNames = "product", key = "'productInfoRedis'")
    public String updateProduct(Integer price) {
        ProductInfo productInfo = productRepository.findByProductId("1");
        log.info(productInfo.toString());
        productInfo.setProductPrice(new BigDecimal(price));
        ProductInfo save = productRepository.save(productInfo);
        log.info("保存之后的信息:{}", save.toString());
        return "OK";
    }
}