package com.mall.order.application.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 订单响应DTO
 */
@Data
public class OrderResponse {
    
    private Long ordersId;
    private Long ordersSn;
    private Integer memberId;
    private String memberName;
    private Integer ordersState;
    private String ordersStateText;
    private Integer ordersType;
    private BigDecimal ordersAmount;
    private BigDecimal finalAmount;
    private BigDecimal freightAmount;
    private BigDecimal couponAmount;
    private BigDecimal preDepositAmount;
    private BigDecimal refundAmount;
    private String ordersFrom;
    private Integer paymentState;
    private LocalDateTime createTime;
    private LocalDateTime paymentTime;
    private LocalDateTime sendTime;
    private LocalDateTime finishTime;
    private LocalDateTime cancelTime;
    private String cancelReason;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private String receiverAreaInfo;
    private String receiverMessage;
    private String paymentCode;
    private String paymentTypeCode;
    private String shipCode;
    private String shipName;
    private String shipSn;
    private String ordersNote;
    private Integer storeId;
    private String storeName;
    private String invoiceTitle;
    private String invoiceContent;
    private String invoiceCode;
    private List<OrderGoodsResponse> orderGoodsList;
    
    @Data
    public static class OrderGoodsResponse {
        private Long ordersGoodsId;
        private Integer goodsId;
        private Integer commonId;
        private String goodsName;
        private String goodsImage;
        private String goodsSerial;
        private String goodsFullSpecs;
        private BigDecimal goodsPrice;
        private Integer buyNum;
        private BigDecimal goodsPayAmount;
        private String unitName;
        private Integer categoryId;
        private Integer storeId;
        private BigDecimal refundPrice;
    }
}