package com.mall.order.adapter.out.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.order.adapter.out.persistence.entity.OrderJpaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单Mapper接口
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderJpaEntity> {
    
    /**
     * 根据会员ID查询订单列表
     */
    List<OrderJpaEntity> findByMemberId(@Param("memberId") Integer memberId);
    
    /**
     * 根据订单号查询订单
     */
    OrderJpaEntity findByOrdersSn(@Param("ordersSn") Long ordersSn);
    
    /**
     * 根据订单状态查询订单列表
     */
    List<OrderJpaEntity> findByOrdersState(@Param("ordersState") Integer ordersState);
    
    /**
     * 根据店铺ID查询订单列表
     */
    List<OrderJpaEntity> findByStoreId(@Param("storeId") Integer storeId);
}