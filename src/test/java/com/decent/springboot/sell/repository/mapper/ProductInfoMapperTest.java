package com.decent.springboot.sell.repository.mapper;

import com.decent.springboot.sell.entity.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

/**
 * @author jiangyu
 * @date 2019/7/2 22:46
 * @email jiangyu9633@foxmail.com
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class ProductInfoMapperTest {
    @Autowired
    private ProductInfoMapper mapper;

    @Test
    public void testMapperQuery() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 1);
        ProductInfo productInfo = mapper.queryProductInfo(map);
        log.info(productInfo.toString());
    }
}