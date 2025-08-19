package com.mall.order.application.service;

import com.mall.order.application.dto.OrderResponse;
import com.mall.order.application.port.in.GetOrderByOrderSnCase;
import com.mall.order.application.port.out.OrderRepository;
import com.mall.order.common.enums.Resp;
import com.mall.order.common.exception.BusinessException;
import com.mall.order.domain.model.order.Order;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 *
 * @author yangfei
 */
@Slf4j
@Service
public class GetOrderByOrderSnCaseService implements GetOrderByOrderSnCase {

    private final OrderRepository orderRepository;

    @Resource
    private OrderConvertToResponseService orderConvertToResponseService;

    public GetOrderByOrderSnCaseService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public OrderResponse getOrderByOrdersSn(Long ordersSn) {
        log.info("根据订单号查询订单: orderSn={}",ordersSn);

        Order order = orderRepository.findByOrdersSn(ordersSn)
                .orElseThrow(() -> new BusinessException(Resp.ORDER_NOT_FOUND));

        return orderConvertToResponseService.convertToResponse(order);
    }
}
