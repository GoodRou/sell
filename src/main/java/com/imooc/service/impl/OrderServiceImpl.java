package com.imooc.service.impl;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dataobject.OrderMaster;
import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.repository.OrderDetailRepository;
import com.imooc.repository.OrderMasterRepository;
import com.imooc.service.OrderService;
import com.imooc.service.ProductService;
import com.imooc.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.Oneway;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author GOODRR
 * @Date 2019/9/5 15:42
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
    String orderId = KeyUtil.genUniqueKey();
    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO)
    {
        //1. 查询商品(数量, 价格)
        List<OrderDetail> orderDetailList = orderDTO.getOrderDetailList();
        for (OrderDetail orderdetail : orderDetailList)
        {
            Optional<ProductInfo> productInfo = productService.findById(orderdetail.getProductId());
            if (!productInfo.isPresent())
            {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2. 计算总价
            orderAmount = productInfo.get().getProductPrice().multiply(new BigDecimal(orderdetail.getProductQuantity())).add(orderAmount);
            //3.写入订单数据库(orderMaster, orderDetail)
            //orderDetail
            orderdetail.setDetailId(KeyUtil.genUniqueKey());
            orderdetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,orderdetail);
            orderDetailRepository.save(orderdetail);
        }
        //orderMaster
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        //4.扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e -> new CartDTO(e.getProductId(),e.getProductQuantity())).collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);
        return orderDTO;
    }

    @Override
    public OrderDTO findById(String orderId)
    {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable)
    {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO)
    {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO)
    {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO)
    {
        return null;
    }
}
