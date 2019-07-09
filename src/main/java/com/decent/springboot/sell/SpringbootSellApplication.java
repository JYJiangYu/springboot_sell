package com.decent.springboot.sell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author jiangyu
 */
@SpringBootApplication
@EnableCaching
public class SpringbootSellApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSellApplication.class, args);
    }

}
