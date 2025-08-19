package com.mall.order.application.service;

import com.mall.order.application.dto.OrderResponse;
import com.mall.order.application.port.in.GetOrdersByQueryCase;
import com.mall.order.application.port.out.OrderRepository;
import com.mall.order.application.query.OrderQuery;
import com.mall.order.common.enums.Resp;
import com.mall.order.common.exception.BusinessException;
import com.mall.order.domain.model.order.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 查询用户订单列表
 * @param query 查询条件
 * @return 订单列表
 * @author yangfei
 */
@Slf4j
@Service
public class GetOrdersByQueryService implements GetOrdersByQueryCase {
    private final OrderRepository orderRepository;

    @Override
    public List<OrderResponse> getOrdersByQuery(OrderQuery query) {
        log.info("根据查询条件查询订单列表: {}", query);

        List<Order> orders;

        if (query.getMemberId() != null) {
            orders = orderRepository.findByMemberId(query.getMemberId());
        } else if (query.getOrderState() != null) {
            orders = orderRepository.findByOrdersState(query.getOrderState());
        } else if (query.getStoreId() != null) {
            orders = orderRepository.findByStoreId(query.getStoreId());
        } else {
            throw new BusinessException(Resp.INVALID_PARAM);
        }

        // 根据订单状态过滤
        if (query.getOrderState() != null && query.getMemberId() != null) {
            orders = orders.stream()
                    .filter(order -> query.getOrderState().equals(order.getOrdersState()))
                    .collect(Collectors.toList());
        }

        // 分页处理（简单实现，实际项目中建议使用MyBatis-Plus的分页插件）
        if (query.getPage() != null && query.getSize() != null) {
            int start = (query.getPage() - 1) * query.getSize();
            int end = Math.min(start + query.getSize(), orders.size());
            if (start < orders.size()) {
                orders = orders.subList(start, end);
            } else {
                orders = List.of();
            }
        }

        return orders.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

}
