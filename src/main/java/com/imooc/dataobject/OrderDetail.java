package com.imooc.dataobject;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @ClassName OrderDetail
 * @Description
 * @Author GOODRR
 * @Date 2019/9/5 14:27
 * @Version 1.0
 **/
@Data
@Entity
public class OrderDetail
{
    @Id
    private String detailId;
    /** 订单id. */
    private String orderId;
    /** 商品id. */
    private String productId;
    /** 商品名称. */
    private String productName;
    /** 商品单价. */
    private BigDecimal productPrice;
    /** 商品数量. */
    private Integer productQuantity;
    /** 商品小图. */
    private String productIcon;

    public OrderDetail()
    {
        super();
    }
    public OrderDetail(String productId,Integer productQuantity)
    {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

}
