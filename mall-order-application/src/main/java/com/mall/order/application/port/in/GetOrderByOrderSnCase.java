package com.mall.order.application.port.in;

import com.mall.order.application.dto.OrderResponse;

public interface GetOrderByOrderSnCase {
    /**
     * 根据订单号查询订单
     * @param ordersSn 订单号
     * @return 订单响应
     */
    OrderResponse getOrderByOrdersSn(Long ordersSn);
}
