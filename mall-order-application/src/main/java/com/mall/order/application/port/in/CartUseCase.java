package com.mall.order.application.port.in;

import com.mall.order.application.command.AddToCartCommand;
import com.mall.order.application.command.UpdateCartCommand;
import com.mall.order.application.dto.CartResponse;

import java.util.List;

/**
 * 购物车用例接口
 */
public interface CartUseCase {
    
    /**
     * 添加商品到购物车
     */
    void addToCart(AddToCartCommand command);
    
    /**
     * 更新购物车商品数量
     */
    void updateCart(UpdateCartCommand command);
    
    /**
     * 从购物车删除商品
     */
    void removeFromCart(Long cartId);
    
    /**
     * 查询会员购物车
     */
    List<CartResponse> getCartByMemberId(Integer memberId);
    
    /**
     * 清空购物车
     */
    void clearCart(Integer memberId);
}