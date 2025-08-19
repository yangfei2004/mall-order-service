package com.mall.order.application.port.out;

import com.mall.order.domain.model.cart.Cart;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 购物车仓储接口
 */
@Repository
public interface CartRepository {
    
    /**
     * 保存购物车项
     */
    Cart save(Cart cart);
    
    /**
     * 根据ID查询购物车项
     */
    Optional<Cart> findById(Long cartId);
    
    /**
     * 根据会员ID查询购物车列表
     */
    List<Cart> findByMemberId(Integer memberId);
    
    /**
     * 根据会员ID和商品ID查询购物车项
     */
    Optional<Cart> findByMemberIdAndGoodsId(Integer memberId, Integer goodsId);
    
    /**
     * 根据ID删除购物车项
     */
    void deleteById(Long cartId);
    
    /**
     * 根据会员ID删除购物车
     */
    void deleteByMemberId(Integer memberId);
    
    /**
     * 检查购物车项是否存在
     */
    boolean existsById(Long cartId);
}