package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName ProductService
 * @Description TODO
 * @Author GOODRR
 * @Date 2019/9/4 14:42
 * @Version 1.0
 **/
public interface ProductService
{
    Optional<ProductInfo> findById(String productId);
    /**
     * 查询所有在架商品
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存

    //减库存
}
