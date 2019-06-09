package com.decent.springboot_sell.repository;

import com.decent.springboot_sell.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void test1() {
        //repository.save(new ProductCategory("All Types", 1));
        Optional<ProductCategory> optional = repository.findById(1);
        ProductCategory productCategory = optional.get();
        System.out.println(productCategory);
        //productCategory.setCategoryName("All Types");
        productCategory.setCategoryName("All Types");
        ProductCategory save = repository.save(productCategory);
    }

}