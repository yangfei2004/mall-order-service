package com.mall.order.application.port.in;

import com.mall.order.application.dto.OrderResponse;

import java.util.List;

public interface GetUserOrdersCase {
    /**
 * 查询用户订单列表
 * @param query 查询条件
 * @return 订单列表
 */
List<OrderResponse> getUserOrders(OrderQuery query);
}
