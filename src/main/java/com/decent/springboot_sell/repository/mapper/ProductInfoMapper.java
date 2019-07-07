package com.decent.springboot_sell.repository.mapper;

import com.decent.springboot_sell.entity.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author jiangyu
 * @date 2019/7/2 22:42
 * @email jiangyu9633@foxmail.com
 */
@Mapper
public interface ProductInfoMapper {
    @Select("select * from product_info where product_id = #{id} ")
    @Results({
            @Result(column = "product_id",property = "productId")
    })
    ProductInfo queryProductInfo(Map<String, Object> map);
}