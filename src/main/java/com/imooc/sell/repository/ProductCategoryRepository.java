package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName ProductCategoryRepository
 * @Description TODO
 * @Author GOODRR
 * @Date 2019/9/3 15:24
 * @Version 1.0
 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>
{
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
