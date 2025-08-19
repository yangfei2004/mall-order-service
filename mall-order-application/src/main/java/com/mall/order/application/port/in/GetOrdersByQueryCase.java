package com.mall.order.application.port.in;

import com.mall.order.application.dto.OrderResponse;
import com.mall.order.application.query.OrderQuery;

import java.util.List;

public interface GetOrdersByQueryCase {
    List<OrderResponse> getOrdersByQuery(OrderQuery query);
}
