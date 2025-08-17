package com.mall.order.adapter.out.persistence.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单商品实体
 */
@Data
@TableName("orders_goods")
public class OrderGoodsJpaEntity {
    
    @TableId(value = "orders_goods_id", type = IdType.AUTO)
    private Long ordersGoodsId;
    
    @TableField("orders_id")
    private Integer ordersId;
    
    @TableField("goods_id")
    private Integer goodsId;
    
    @TableField("goods_name")
    private String goodsName;
    
    @TableField("goods_image")
    private String goodsImage;
    
    @TableField("goods_price")
    private BigDecimal goodsPrice;
    
    @TableField("goods_pay_amount")
    private BigDecimal goodsPayAmount;
    
    @TableField("buy_num")
    private Integer buyNum;
    
    @TableField("goods_serial")
    private String goodsSerial;
    
    @TableField("goods_full_specs")
    private String goodsFullSpecs;
    
    @TableField("goods_type")
    private Integer goodsType;
    
    @TableField("common_id")
    private Integer commonId;
    
    @TableField("member_id")
    private Integer memberId;
    
    @TableField("store_id")
    private Integer storeId;
    
    @TableField("category_id")
    private Integer categoryId;
    
    @TableField("category_id_1")
    private Integer categoryId1;
    
    @TableField("category_id_2")
    private Integer categoryId2;
    
    @TableField("category_id_3")
    private Integer categoryId3;
    
    @TableField("commission_rate")
    private Integer commissionRate;
    
    @TableField("base_price")
    private BigDecimal basePrice;
    
    @TableField("refund_price")
    private BigDecimal refundPrice;
    
    @TableField("tax_amount")
    private BigDecimal taxAmount;
    
    @TableField("tax_rate")
    private BigDecimal taxRate;
    
    @TableField("unit_name")
    private String unitName;
    
    @TableField("promotion_title")
    private String promotionTitle;
    
    @TableField("contract")
    private String contract;
    
    @TableField("bundling_id")
    private Integer bundlingId;
    
    @TableField("bargain_open_id")
    private Integer bargainOpenId;
    
    @TableField("seckill_goods_id")
    private Integer seckillGoodsId;
    
    @TableField("distribution_orders_id")
    private Integer distributionOrdersId;
    
    @TableField("complain_id")
    private Integer complainId;
    
    @TableField("trys_apply_id")
    private Integer trysApplyId;
    
    @TableField("join_big_sale")
    private Integer joinBigSale;
    
    @TableField(value = "created_at", fill = FieldFill.INSERT)
    private LocalDateTime createdAt;
    
    @TableField(value = "created_by", fill = FieldFill.INSERT)
    private Long createdBy;
    
    @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;
    
    @TableField(value = "updated_by", fill = FieldFill.INSERT_UPDATE)
    private Long updatedBy;
    
    @TableField("is_deleted")
    @TableLogic
    private Integer isDeleted;
}