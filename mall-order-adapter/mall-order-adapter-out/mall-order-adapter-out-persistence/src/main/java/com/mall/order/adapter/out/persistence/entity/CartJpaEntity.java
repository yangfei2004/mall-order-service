package com.mall.order.adapter.out.persistence.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 购物车实体
 */
@Data
@TableName("cart")
public class CartJpaEntity {
    
    @TableId(value = "cart_id", type = IdType.AUTO)
    private Long cartId;
    
    @TableField("member_id")
    private Integer memberId;
    
    @TableField("goods_id")
    private Integer goodsId;
    
    @TableField("common_id")
    private Integer commonId;
    
    @TableField("buy_num")
    private Integer buyNum;
    
    @TableField("bundling_id")
    private Integer bundlingId;
    
    @TableField("distribution_orders_id")
    private Integer distributionOrdersId;
    
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