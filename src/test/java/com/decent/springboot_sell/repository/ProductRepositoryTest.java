package com.decent.springboot_sell.repository;

import com.decent.springboot_sell.ProductStateEnum;
import com.decent.springboot_sell.entity.ProductCategory;
import com.decent.springboot_sell.entity.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository repository;


    @Test
    //@Transactional //在这里起回滚作用
    public void testSave() {
        //ProductInfo productInfo = new ProductInfo();
        ProductInfo productInfo = ProductInfo.builder().productId("1").productName("冰可乐").
                productPrice(new BigDecimal(3)).productStock(20).
                productIcon("http://baidu.com").productStatus(ProductStateEnum.UP.getCode()).categoryType(2).build();
        repository.save(productInfo);
        List<ProductInfo> byProductStatus = repository.findByProductStatus(ProductStateEnum.UP.getCode());
        log.error(byProductStatus + "\n");
        //ProductCategory save = repository.save(productCategory);

    }


    @Test
    //@Transactional 在这里起回滚作用
    public void testQuery() {
        Optional<ProductInfo> optional = repository.findById("2");
        ProductInfo productInfo = optional.orElseGet(() -> ProductInfo.builder().productName("noName...").build());
        log.info("\n======" + productInfo + "\n");
        Assert.assertEquals("noName...", productInfo.getProductName());


    }


    @Test
    //@Transactional 在这里起回滚作用
    public void findAllTest() {
        Page<ProductInfo> all = repository.findAll(new PageRequest(0, 2));
        System.out.println(all.getContent());

    }


}