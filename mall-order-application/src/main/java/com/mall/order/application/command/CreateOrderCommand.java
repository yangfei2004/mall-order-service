package com.mall.order.application.command;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 创建订单命令
 */
@Data
public class CreateOrderCommand {
    
    private Integer memberId;
    private String memberName;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private String receiverAreaInfo;
    private String receiverMessage;
    private BigDecimal freightAmount;
    private BigDecimal couponAmount;
    private String invoiceTitle;
    private String invoiceContent;
    private String ordersNote;
    private List<OrderGoodsCommand> orderGoodsList;
    
    @Data
    public static class OrderGoodsCommand {
        private Integer goodsId;
        private Integer commonId;
        private String goodsName;
        private String goodsImage;
        private BigDecimal goodsPrice;
        private Integer buyNum;
        private String unitName;
        private Integer categoryId;
        private Integer storeId;
    }
}