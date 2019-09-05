package com.imooc.service.impl;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest
{
    @Autowired
    private OrderServiceImpl orderService;

    private static final String BUYER_OPENID = "739092";

    @Test
    public void create()
    {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("大乐透");
        orderDTO.setBuyerAddress("透透透");
        orderDTO.setBuyerPhone("13256722119");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("0011");
        o1.setProductQuantity(2);
        orderDetailList.add(o1);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单] result={}",result);
    }

    @Test
    public void findById()
    {
    }

    @Test
    public void findList()
    {
    }

    @Test
    public void cancel()
    {
    }

    @Test
    public void finish()
    {
    }

    @Test
    public void paid()
    {
    }
}