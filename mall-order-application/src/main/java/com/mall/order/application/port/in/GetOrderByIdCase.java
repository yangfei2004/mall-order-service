package com.mall.order.application.port.in;

import com.mall.order.application.dto.OrderResponse;

public interface GetOrderByIdCase {
    /**
     *
     * 根据ID查询订单
     * @param orderId 订单ID
     * @return 订单响应
     */
    OrderResponse getOrderById(Long orderId);
}
