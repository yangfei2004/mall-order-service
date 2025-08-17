package com.mall.order.adapter.out.persistence.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单实体
 */
@Data
@TableName("orders")
public class OrderJpaEntity {
    
    @TableId(value = "orders_id", type = IdType.AUTO)
    private Long ordersId;
    
    @TableField("orders_sn")
    private Long ordersSn;
    
    @TableField("member_id")
    private Integer memberId;
    
    @TableField("member_name")
    private String memberName;
    
    @TableField("orders_state")
    private Integer ordersState;
    
    @TableField("orders_type")
    private Integer ordersType;
    
    @TableField("orders_amount")
    private BigDecimal ordersAmount;
    
    @TableField("final_amount")
    private BigDecimal finalAmount;
    
    @TableField("freight_amount")
    private BigDecimal freightAmount;
    
    @TableField("coupon_amount")
    private BigDecimal couponAmount;
    
    @TableField("predeposit_amount")
    private BigDecimal preDepositAmount;
    
    @TableField("refund_amount")
    private BigDecimal refundAmount;
    
    @TableField("orders_from")
    private String ordersFrom;
    
    @TableField("create_time")
    private LocalDateTime createTime;
    
    @TableField("payment_time")
    private LocalDateTime paymentTime;
    
    @TableField("send_time")
    private LocalDateTime sendTime;
    
    @TableField("finish_time")
    private LocalDateTime finishTime;
    
    @TableField("cancel_time")
    private LocalDateTime cancelTime;
    
    @TableField("cancel_reason")
    private String cancelReason;
    
    @TableField("cancel_role")
    private Integer cancelRole;
    
    @TableField("receiver_name")
    private String receiverName;
    
    @TableField("receiver_phone")
    private String receiverPhone;
    
    @TableField("reciver_address")
    private String receiverAddress;
    
    @TableField("receiver_area_info")
    private String receiverAreaInfo;
    
    @TableField("receiver_message")
    private String receiverMessage;
    
    @TableField("payment_code")
    private String paymentCode;
    
    @TableField("payment_type_code")
    private String paymentTypeCode;
    
    @TableField("ship_code")
    private String shipCode;
    
    @TableField("ship_name")
    private String shipName;
    
    @TableField("ship_sn")
    private String shipSn;
    
    @TableField("orders_note")
    private String ordersNote;
    
    @TableField("store_id")
    private Integer storeId;
    
    @TableField("store_name")
    private String storeName;
    
    @TableField("lock_state")
    private Integer lockState;
    
    @TableField("delete_state")
    private Integer deleteState;
    
    @TableField("evaluation_state")
    private Integer evaluationState;
    
    @TableField("evaluation_time")
    private LocalDateTime evaluationTime;
    
    @TableField("refund_state")
    private Integer refundState;
    
    @TableField("invoice_title")
    private String invoiceTitle;
    
    @TableField("invoice_content")
    private String invoiceContent;
    
    @TableField("invoice_code")
    private String invoiceCode;
    
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