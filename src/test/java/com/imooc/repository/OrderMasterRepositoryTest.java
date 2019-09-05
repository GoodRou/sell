package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest
{
    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest()
    {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("狗子");
        orderMaster.setBuyerPhone("15668373725");
        orderMaster.setBuyerAddress("历城区");
        orderMaster.setBuyerOpenid("739092");
        orderMaster.setOrderAmount(new BigDecimal(5.5));

        OrderMaster save = repository.save(orderMaster);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByOrOrderId()
    {
        PageRequest request = PageRequest.of(0,4);
        Page<OrderMaster> result = repository.findByBuyerOpenid("739092", request);
        Assert.assertNotEquals(0,result.getTotalElements());
        System.out.println(result.getTotalElements());
    }
}