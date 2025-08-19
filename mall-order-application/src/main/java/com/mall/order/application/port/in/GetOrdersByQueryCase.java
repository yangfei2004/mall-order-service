package com.mall.order.application.port.in;

import com.mall.order.application.dto.OrderResponse;
import com.mall.order.application.query.OrderQuery;

import java.util.List;
/**
 *
 * 查询用户订单列表
 * @param query 查询条件
 * @return 订单列表
 * @author yangfei
 */
public interface GetOrdersByQueryCase {
    List<OrderResponse> getOrdersByQuery(OrderQuery query);
}
