package com.mall.order.application.command;

import lombok.Data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * 添加到购物车命令
 */
@Data
public class AddToCartCommand {
    
    @NotNull(message = "会员ID不能为空")
    private Integer memberId;
    
    @NotNull(message = "商品ID不能为空")
    private Integer goodsId;
    
    @NotNull(message = "商品通用ID不能为空")
    private Integer commonId;
    
    @NotNull(message = "购买数量不能为空")
    @Positive(message = "购买数量必须大于0")
    private Integer buyNum;
    
    private Integer bundlingId;
    
    private Integer distributionOrdersId;
}