package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest
{
    @Autowired
    ProductCategoryRepository repository;

    @Test
    public void findOneTest()
    {
        Optional<ProductCategory> productCategory = repository.findById(5);
        System.out.println("productCategory = " + productCategory.toString());
    }

    @Test
    public void saveTest()
    {
        ProductCategory productCategory = new ProductCategory("RR",3);
        repository.save(productCategory);
    }

    @Test
    public void updateTest()
    {
        List<ProductCategory> list = repository.findAll();
        list.get(1).setCategoryType(3);
        ProductCategory result = repository.save(list.get(1));
        Assert.assertNotNull(result);
//        Assert.assertEquals(null,result);
    }

    @Test
    public void findByCategoryTypeIn()
    {
        List<Integer> list = Arrays.asList(1,3);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}