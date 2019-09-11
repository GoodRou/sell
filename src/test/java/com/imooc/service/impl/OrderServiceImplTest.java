package com.imooc.service.impl;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.math.BigDecimal;
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

    private final String BUYER_OPENID = "739092";

    private final String ORDER_ID = "1567750837510771776";

    @Test
    public void create()
    {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("好个肉肉");
        orderDTO.setBuyerAddress("在水一方");
        orderDTO.setBuyerPhone("15668373725");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail("0011",1);
        OrderDetail o2 = new OrderDetail("0012",1);
        OrderDetail o3 = new OrderDetail("0031",1);
        OrderDetail o4 = new OrderDetail("0032",1);

        orderDetailList.add(o1);
        orderDetailList.add(o2);
        orderDetailList.add(o3);
        orderDetailList.add(o4);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findById()
    {
        OrderDTO result = orderService.findById(ORDER_ID);
        log.info("[查询单个订单] result={}", result);
        Assert.assertEquals(ORDER_ID,result.getOrderId());
    }

    @Test
    public void findList()
    {
        PageRequest pageRequest = PageRequest.of(0,2);
        Page<OrderDTO> list = orderService.findList(BUYER_OPENID, pageRequest);
        Assert.assertNotEquals(0,list.getTotalElements());
    }

    @Test
    public void cancel()
    {
        OrderDTO result = orderService.findById(ORDER_ID);
        OrderDTO orderDTO = orderService.cancel(result);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),orderDTO.getOrderStatus());
    }

    @Test
    public void finish()
    {
        OrderDTO result = orderService.findById(ORDER_ID);
        OrderDTO orderDTO = orderService.finish(result);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),orderDTO.getOrderStatus());
    }

    @Test
    public void paid()
    {
        OrderDTO result = orderService.findById(ORDER_ID);
        OrderDTO orderDTO = orderService.paid(result);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),orderDTO.getPayStatus());
    }
}