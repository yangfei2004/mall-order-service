package com.mall.order.application.port.in;

public interface CartRemoveCase {
    /**
     * 从购物车删除商品
     * @author yangfei
     */
    void removeFromCart(Long cartId);

}
