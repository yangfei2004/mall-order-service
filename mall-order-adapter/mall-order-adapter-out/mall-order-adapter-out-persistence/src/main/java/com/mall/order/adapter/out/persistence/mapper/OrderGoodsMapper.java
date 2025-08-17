package com.mall.order.adapter.out.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.order.adapter.out.persistence.entity.OrderGoodsJpaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单商品Mapper接口
 */
@Mapper
public interface OrderGoodsMapper extends BaseMapper<OrderGoodsJpaEntity> {
    
    /**
     * 根据订单ID查询订单商品列表
     */
    List<OrderGoodsJpaEntity> findByOrdersId(@Param("ordersId") Integer ordersId);
    
    /**
     * 根据商品ID查询订单商品列表
     */
    List<OrderGoodsJpaEntity> findByGoodsId(@Param("goodsId") Integer goodsId);
    
    /**
     * 根据会员ID查询订单商品列表
     */
    List<OrderGoodsJpaEntity> findByMemberId(@Param("memberId") Integer memberId);
}