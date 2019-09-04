package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRespositoryTest
{
    @Autowired
    private ProductInfoRespository respository;

    @Test
    public void saveTest()
    {
        ProductInfo p = new ProductInfo();
        p.setProductId("123456");
        p.setProductName("皮蛋粥");
        p.setProductPrice(new BigDecimal(3.5));
        p.setProductStock(100);
        p.setProductDescription("一碗粥");
        p.setProductIcon("http://rr.jpg");
        p.setProductStatus(0);
        p.setCategoryType(2);

        ProductInfo save = respository.save(p);
        Assert.assertNotNull(save);
    }
    @Test
    public void findByProductStatus()
    {
        List<ProductInfo> list = respository.findByProductStatus(0);
        Assert.assertNotEquals(0,list.size());
    }
}