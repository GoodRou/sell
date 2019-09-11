package com.imooc.dto;

import lombok.Data;

/**
 * @ClassName CartDTO
 * @Description
 * @Author GOODRR
 * @Date 2019/9/5 16:20
 * @Version 1.0
 **/
@Data
public class CartDTO
{
    /** 数量*/
    private String productId;
    /** 商品ID*/
    private Integer priductQuantity;


    public CartDTO(String productId, Integer priductQuantity)
    {
        this.priductQuantity = priductQuantity;
        this.productId = productId;
    }
}
