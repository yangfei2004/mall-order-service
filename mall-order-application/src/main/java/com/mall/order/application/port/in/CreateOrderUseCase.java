package com.mall.order.application.port.in;

import com.mall.order.application.command.CreateOrderCommand;
import com.mall.order.application.dto.OrderResponse;

/**
 * 创建订单用例
 */
public interface CreateOrderUseCase {

    /**
     * 创建订单
     * @author yangfei
     * @param command 创建订单命令
     * @return 订单响应
     */
    OrderResponse createOrder(CreateOrderCommand command);
}