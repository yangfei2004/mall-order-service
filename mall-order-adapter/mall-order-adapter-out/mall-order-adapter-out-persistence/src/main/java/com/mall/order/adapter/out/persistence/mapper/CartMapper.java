package com.mall.order.adapter.out.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.order.adapter.out.persistence.entity.CartJpaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 购物车Mapper接口
 */
@Mapper
public interface CartMapper extends BaseMapper<CartJpaEntity> {
    
    /**
     * 根据会员ID查询购物车列表
     */
    List<CartJpaEntity> findByMemberId(@Param("memberId") Integer memberId);
    
    /**
     * 根据会员ID和商品ID查询购物车项
     */
    CartJpaEntity findByMemberIdAndGoodsId(@Param("memberId") Integer memberId, 
                                          @Param("goodsId") Integer goodsId);
    
    /**
     * 根据会员ID删除购物车项
     */
    int deleteByMemberId(@Param("memberId") Integer memberId);
}