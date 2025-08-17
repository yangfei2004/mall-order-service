package com.mall.order.application.command;

import lombok.Data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * 更新购物车命令
 */
@Data
public class UpdateCartCommand {
    
    private Long cartId;
    
    @NotNull(message = "购买数量不能为空")
    @Positive(message = "购买数量必须大于0")
    private Integer buyNum;
}