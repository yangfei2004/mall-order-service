package com.mall.order.adapter.out.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.order.adapter.out.persistence.entity.RefundJpaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 退款Mapper接口
 */
@Mapper
public interface RefundMapper extends BaseMapper<RefundJpaEntity> {
    
    /**
     * 根据订单ID查询退款列表
     */
    List<RefundJpaEntity> findByOrdersId(@Param("ordersId") Integer ordersId);
    
    /**
     * 根据会员ID查询退款列表
     */
    List<RefundJpaEntity> findByMemberId(@Param("memberId") Integer memberId);
    
    /**
     * 根据退款号查询退款
     */
    RefundJpaEntity findByRefundSn(@Param("refundSn") Long refundSn);
    
    /**
     * 根据退款状态查询退款列表
     */
    List<RefundJpaEntity> findByRefundState(@Param("refundState") Integer refundState);
}