package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
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

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest
{
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest()
    {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("777777");
        orderDetail.setOrderId("654789123");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("11111112");
        orderDetail.setProductName("勇闯天涯");
        orderDetail.setProductPrice(new BigDecimal(3));
        orderDetail.setProductQuantity(999);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrOrderId()
    {
        List<OrderDetail> orderDetailList = repository.findByOrOrderId("654789123");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}