package com.mall.order.application.query;

import lombok.Data;

@Data
public class OrderQuery {
    private Integer memberId;
    private Integer orderState;
    private Integer page;
    private Integer size;
    private Integer storeId;
}
