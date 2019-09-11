package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName ProductCategoryRepository
 * @Description
 * @Author GOODRR
 * @Date 2019/9/3 15:24
 * @Version 1.0
 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>
{
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
