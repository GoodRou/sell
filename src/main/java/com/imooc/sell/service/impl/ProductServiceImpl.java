package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.ProductStatusEnum;
import com.imooc.sell.repository.ProductInfoRespository;
import com.imooc.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName ProductServiceImpl
 * @Description TODO
 * @Author GOODRR
 * @Date 2019/9/4 14:50
 * @Version 1.0
 **/
@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductInfoRespository respository;

    @Override
    public Optional<ProductInfo> findById(String productId)
    {
        return respository.findById(productId);
    }

    @Override
    public List<ProductInfo> findUpAll()
    {
        return respository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable)
    {
        return respository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo)
    {
        return respository.save(productInfo);
    }
}
