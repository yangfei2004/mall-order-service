package com.mall.order.domain.event;

import lombok.Getter;

/**
 * 订单状态变更事件
 */
@Getter
public class OrderStatusChangedEvent extends DomainEvent {
    
    private final Long ordersSn;
    private final Integer oldStatus;
    private final Integer newStatus;
    
    public OrderStatusChangedEvent(Long ordersSn, Integer oldStatus, Integer newStatus) {
        super();
        this.ordersSn = ordersSn;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
    }
}