package com.mall.order.adapter.out.persistence.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 退款实体
 */
@Data
@TableName("refund")
public class RefundJpaEntity {
    
    @TableId(value = "refund_id", type = IdType.AUTO)
    private Long refundId;
    
    @TableField("refund_sn")
    private Long refundSn;
    
    @TableField("orders_id")
    private Integer ordersId;
    
    @TableField("orders_sn")
    private Long ordersSn;
    
    @TableField("orders_goods_id")
    private Integer ordersGoodsId;
    
    @TableField("member_id")
    private Integer memberId;
    
    @TableField("member_name")
    private String memberName;
    
    @TableField("store_id")
    private Integer storeId;
    
    @TableField("store_name")
    private String storeName;
    
    @TableField("goods_id")
    private Integer goodsId;
    
    @TableField("goods_name")
    private String goodsName;
    
    @TableField("goods_image")
    private String goodsImage;
    
    @TableField("goods_num")
    private Integer goodsNum;
    
    @TableField("refund_amount")
    private BigDecimal refundAmount;
    
    @TableField("refund_type")
    private Integer refundType;
    
    @TableField("refund_state")
    private Integer refundState;
    
    @TableField("return_type")
    private Integer returnType;
    
    @TableField("reason_id")
    private Integer reasonId;
    
    @TableField("reason_info")
    private String reasonInfo;
    
    @TableField("buyer_message")
    private String buyerMessage;
    
    @TableField("seller_message")
    private String sellerMessage;
    
    @TableField("admin_message")
    private String adminMessage;
    
    @TableField("pic_json")
    private String picJson;
    
    @TableField("add_time")
    private LocalDateTime addTime;
    
    @TableField("seller_time")
    private LocalDateTime sellerTime;
    
    @TableField("admin_time")
    private LocalDateTime adminTime;
    
    @TableField("receive_time")
    private LocalDateTime receiveTime;
    
    @TableField("ship_time")
    private LocalDateTime shipTime;
    
    @TableField("bill_time")
    private LocalDateTime billTime;
    
    @TableField("delay_time")
    private LocalDateTime delayTime;
    
    @TableField("seller_state")
    private Integer sellerState;
    
    @TableField("admin_state")
    private Integer adminState;
    
    @TableField("goods_state")
    private Integer goodsState;
    
    @TableField("order_lock")
    private Integer orderLock;
    
    @TableField("ship_id")
    private Integer shipId;
    
    @TableField("ship_sn")
    private String shipSn;
    
    @TableField("receive_message")
    private String receiveMessage;
    
    @TableField("commission_rate")
    private Integer commissionRate;
    
    @TableField("coupon_amount")
    private BigDecimal couponAmount;
    
    @TableField("orders_type")
    private Integer ordersType;
    
    @TableField("order_goods_type")
    private Integer orderGoodsType;
    
    @TableField("common_id")
    private Integer commonId;
    
    @TableField("refund_source")
    private Integer refundSource;
    
    @TableField("refund_member_cancel")
    private Integer refundMemberCancel;
    
    @TableField("return_member_auto_cancel")
    private Integer returnMemberAutoCancel;
    
    @TableField("return_seller_auto_receive")
    private Integer returnSellerAutoReceive;
    
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