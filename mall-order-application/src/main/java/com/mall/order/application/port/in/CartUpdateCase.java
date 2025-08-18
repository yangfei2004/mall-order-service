package com.mall.order.application.port.in;

import com.mall.order.application.command.UpdateCartCommand;

public interface CartUpdateCase {

    /**
     * 更新购物车商品数量
     */
    void updateCart(UpdateCartCommand command);
}
