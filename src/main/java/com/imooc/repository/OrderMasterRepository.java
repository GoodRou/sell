package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName OrderMasterRepository
 * @Description TODO
 * @Author GOODRR
 * @Date 2019/9/5 14:31
 * @Version 1.0
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String>
{
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
