package com.mall.order.domain.model.order;

import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单商品值对象
 */
@Data
public class OrderGoods {
    
    private Long ordersGoodsId;
    private Integer ordersId;
    private Integer goodsId;
    private Integer commonId;
    private String goodsName;
    private String goodsImage;
    private String goodsSerial;
    private String goodsFullSpecs;
    private BigDecimal goodsPrice;
    private BigDecimal basePrice;
    private Integer buyNum;
    private BigDecimal goodsPayAmount;
    private String unitName;
    private Integer categoryId;
    private Integer categoryId1;
    private Integer categoryId2;
    private Integer categoryId3;
    private Integer goodsType;
    private Integer memberId;
    private Integer storeId;
    private BigDecimal refundPrice;
    private Integer complainId;
    private String contract;
    private String promotionTitle;
    private Integer commissionRate;
    private BigDecimal taxAmount;
    private BigDecimal taxRate;
    private Integer bundlingId;
    private Integer distributionOrdersId;
    private Integer bargainOpenId;
    private Integer seckillGoodsId;
    private Integer trysApplyId;
    private Integer joinBigSale;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
    private Integer isDeleted;
    
    /**
     * 创建订单商品
     */
    public static OrderGoods create(Integer goodsId, Integer commonId, String goodsName, 
                                   String goodsImage, BigDecimal goodsPrice, Integer buyNum) {
        OrderGoods orderGoods = new OrderGoods();
        orderGoods.goodsId = goodsId;
        orderGoods.commonId = commonId;
        orderGoods.goodsName = goodsName;
        orderGoods.goodsImage = goodsImage;
        orderGoods.goodsPrice = goodsPrice;
        orderGoods.basePrice = goodsPrice;
        orderGoods.buyNum = buyNum;
        orderGoods.goodsPayAmount = goodsPrice.multiply(BigDecimal.valueOf(buyNum));
        orderGoods.refundPrice = BigDecimal.ZERO;
        orderGoods.isDeleted = 0;
        return orderGoods;
    }
    
    /**
     * 计算商品总价
     */
    public BigDecimal getTotalAmount() {
        return goodsPrice.multiply(BigDecimal.valueOf(buyNum));
    }
}