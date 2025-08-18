package com.mall.order.application.port.in;

import com.mall.order.application.command.AddToCartCommand;

public interface CartAddCase {
    /**
     * 添加商品到购物车
     */
    void addToCart(AddToCartCommand command);

}
