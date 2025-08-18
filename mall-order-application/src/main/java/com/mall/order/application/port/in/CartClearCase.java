package com.mall.order.application.port.in;

public interface CartClearCase {

    /**
     * 清空购物车
     */
    void clearCart(Integer memberId);
}
