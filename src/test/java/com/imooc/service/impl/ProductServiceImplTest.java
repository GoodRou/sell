package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest
{
    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findById()
    {
        Optional<ProductInfo> byId = productService.findById("123456");
        Assert.assertEquals("123456",byId.get().getProductId());
    }

    @Test
    public void findUpAll()
    {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void findAll()
    {
        PageRequest pageRequest = PageRequest.of(0,2);
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
        System.out.println("productInfoPage.getTotalElements() = " + productInfoPage.getTotalElements());
        Assert.assertNotEquals(0,productInfoPage.getTotalElements());
    }

    @Test
    public void save()
    {
        ProductInfo p = new ProductInfo();
        p.setProductId("456789");
        p.setProductName("皮皮虾");
        p.setProductPrice(new BigDecimal(20));
        p.setProductStock(100);
        p.setProductDescription("一只虾");
        p.setProductIcon("http://xia.jpg");
        p.setProductStatus(ProductStatusEnum.DOWN.getCode());
        p.setCategoryType(3);
        productService.save(p);
        Assert.assertNotNull(p);
    }
}