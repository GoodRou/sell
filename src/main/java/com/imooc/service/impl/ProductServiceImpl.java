package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.repository.ProductInfoRespository;
import com.imooc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName ProductServiceImpl
 * @Description
 * @Author GOODRR
 * @Date 2019/9/4 14:50
 * @Version 1.0
 **/
@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductInfoRespository respository;

    @Override
    public Optional<ProductInfo> findById(String productId)
    {
        return respository.findById(productId);
    }

    @Override
    public List<ProductInfo> findUpAll()
    {
        return respository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable)
    {
        return respository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo)
    {
        return respository.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList)
    {
        for (CartDTO cartDTO : cartDTOList)
        {
            Optional<ProductInfo> productInfo = respository.findById(cartDTO.getProductId());
            if(!productInfo.isPresent())
            {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.get().getProductStock() + cartDTO.getPriductQuantity();
            productInfo.get().setProductStock(result);

            respository.save(productInfo.get());
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList)
    {
        for (CartDTO cartDTO : cartDTOList)
        {
            Optional<ProductInfo> info = respository.findById(cartDTO.getProductId());
            if (!info.isPresent()) throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);

            Integer result = info.get().getProductStock() - cartDTO.getPriductQuantity();
            if(result < 0) throw new SellException(ResultEnum.product_stock_error);

            info.get().setProductStock(result);

            respository.save(info.get());
        }
    }
}
