package com.mall.order.application.service;

import com.mall.order.application.dto.OrderResponse;
import com.mall.order.application.port.in.GetOrderByIdCase;
import com.mall.order.application.port.out.OrderRepository;
import com.mall.order.common.enums.Resp;
import com.mall.order.common.exception.BusinessException;
import com.mall.order.domain.model.order.Order;
import org.springframework.stereotype.Service;
/**
 *
 * @author yangfei
 */
@Service
public class GetOrderByIdService implements GetOrderByIdCase {
    private final OrderRepository orderRepository;

    @Override
    public OrderResponse getOrderById(Long orderId) {
        log.info("根据ID查询订单: orderId={}", orderId);

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new BusinessException(Resp.ORDER_NOT_FOUND));

        return convertToResponse(order);
    }
}
