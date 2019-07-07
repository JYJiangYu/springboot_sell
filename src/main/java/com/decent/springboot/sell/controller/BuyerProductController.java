package com.decent.springboot.sell.controller;

import com.decent.springboot.sell.vo.ProductInfoVo;
import com.decent.springboot.sell.vo.ProductResultVo;
import com.decent.springboot.sell.vo.ProductVo;
import com.decent.springboot.sell.enums.ProductStateEnum;
import com.decent.springboot.sell.entity.ProductCategory;
import com.decent.springboot.sell.entity.ProductInfo;
import com.decent.springboot.sell.repository.ProductCategoryRepository;
import com.decent.springboot.sell.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiangyu
 * @date 2019/6/12 21:21
 * @email jiangyu9633@foxmail.com
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @GetMapping("/list")
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
                if (productInfo.getCategoryType() == productCategory.getCategoryType()) {
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
}