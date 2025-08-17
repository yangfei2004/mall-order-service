package com.mall.order.application.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 购物车响应
 */
@Data
public class CartResponse {
    
    private Long cartId;
    private Integer memberId;
    private Integer goodsId;
    private Integer commonId;
    private Integer buyNum;
    private Integer bundlingId;
    private Integer distributionOrdersId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}