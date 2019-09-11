package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName ProductInfoRespository
 * @Description
 * @Author GOODRR
 * @Date 2019/9/4 14:35
 * @Version 1.0
 **/
public interface ProductInfoRespository extends JpaRepository<ProductInfo,String>
{
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
