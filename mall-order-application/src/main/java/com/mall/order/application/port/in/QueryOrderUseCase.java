package com.mall.order.application.port.in;

import com.mall.order.application.dto.OrderResponse;
import com.mall.order.application.query.OrderQuery;

import java.util.List;

/**
 * 查询订单用例
 */
public interface QueryOrderUseCase {
    
    /**
     * 根据ID查询订单
     * @param orderId 订单ID
     * @return 订单响应
     */
    OrderResponse getOrderById(Long orderId);
    
    /**
     * 根据订单号查询订单
     * @param ordersSn 订单号
     * @return 订单响应
     */
    OrderResponse getOrderByOrdersSn(Long ordersSn);
    
    /**
     * 查询用户订单列表
     * @param query 查询条件
     * @return 订单列表
     */
    List<OrderResponse> getUserOrders(OrderQuery query);
}