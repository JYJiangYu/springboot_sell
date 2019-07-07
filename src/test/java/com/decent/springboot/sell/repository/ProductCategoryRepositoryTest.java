package com.decent.springboot.sell.repository;

import com.decent.springboot.sell.entity.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    //@Transactional 在这里起回滚作用
    public void test1() {
        repository.save(new ProductCategory("女最爱", 3));
        Optional<ProductCategory> optional = repository.findById(3);
        ProductCategory productCategory = optional.get();
        log.error(productCategory.toString() + "\n");
        //ProductCategory save = repository.save(productCategory);

    }

    @Test
    @Transactional
    public void test2() {
        List<Integer> list = new ArrayList<>(5);
        list.add(1);
        list.add(3);
        List<ProductCategory> byCategoryTypeIn = repository.findByCategoryTypeIn(list);
        System.out.println(byCategoryTypeIn);
    }


}