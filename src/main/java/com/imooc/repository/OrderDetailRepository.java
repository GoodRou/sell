package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName OrderDetailRepository
 * @Description TODO
 * @Author GOODRR
 * @Date 2019/9/5 14:41
 * @Version 1.0
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String >
{
    List<OrderDetail> findByOrOrderId(String orderId);
}
