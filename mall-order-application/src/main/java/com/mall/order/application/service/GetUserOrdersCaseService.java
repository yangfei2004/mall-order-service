package com.mall.order.application.service;

import com.mall.order.application.dto.OrderResponse;
import com.mall.order.application.port.in.GetUserOrdersCase;

import java.util.List;
@Service
public class GetUserOrdersCaseService implements GetUserOrdersCase {

    @Override
    public List<OrderResponse> getUserOrders(OrderQuery query) {
        return List.of();
    }
}
