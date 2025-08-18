package com.mall.order.application.service;

import com.mall.order.application.dto.OrderResponse;
import com.mall.order.application.port.in.GetOrderByOrderSnCase;
import com.mall.order.application.port.out.OrderRepository;
import com.mall.order.common.enums.Resp;
import com.mall.order.common.exception.BusinessException;
import com.mall.order.domain.model.order.Order;
import org.springframework.stereotype.Service;

@Service
public class GetOrderByOrderSnCaseService implements GetOrderByOrderSnCase {


    private final OrderRepository orderRepository;

    @Override
    public OrderResponse getOrderByOrderSn(Long orderSn) {
        log.info("根据订单号查询订单: orderSn={}", orderSn);

        Order order = orderRepository.findByOrdersSn(orderSn)
                .orElseThrow(() -> new BusinessException(Resp.ORDER_NOT_FOUND));

        return convertToResponse(order);
    }
}
