package com.mall.order.domain.event;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * 订单创建事件
 */
@Getter
public class OrderCreatedEvent extends DomainEvent {
    
    private final Long ordersSn;
    private final Integer memberId;
    private final BigDecimal ordersAmount;
    
    public OrderCreatedEvent(Long ordersSn, Integer memberId, BigDecimal ordersAmount) {
        super();
        this.ordersSn = ordersSn;
        this.memberId = memberId;
        this.ordersAmount = ordersAmount;
    }
}