package com.imooc.service.impl;

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
public class CategoryServiceImplTest
{
    @Autowired
    CategoryServiceImpl categoryServiceimpl;

    @Test
    public void findOne()
    {
        Optional<ProductCategory> one = categoryServiceimpl.findOne(1);
        Assert.assertEquals(new Integer(1),one.get().getCategoryId());
    }

    @Test
    public void findAll()
    {
        List<ProductCategory> productCategories = categoryServiceimpl.findAll();
        Assert.assertNotEquals(0,productCategories.size());
    }

    @Test
    public void findByCategoryTypeIn()
    {
        List<ProductCategory> productCategories = categoryServiceimpl.findByCategoryTypeIn(Arrays.asList(1,3));
        Assert.assertNotEquals(0,productCategories.size());
    }

    @Test
    public void save()
    {
        ProductCategory p = new ProductCategory("gggg",2);
        ProductCategory save = categoryServiceimpl.save(p);
        Assert.assertNotNull(save);
    }
}