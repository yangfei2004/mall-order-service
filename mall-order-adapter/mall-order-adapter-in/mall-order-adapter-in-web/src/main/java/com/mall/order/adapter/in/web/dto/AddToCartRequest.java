package com.mall.order.adapter.in.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * 添加到购物车请求DTO
 */
@Data
@Schema(description = "添加到购物车请求")
public class AddToCartRequest {
    
    @NotNull(message = "会员ID不能为空")
    @Schema(description = "会员ID", example = "1001")
    private Integer memberId;
    
    @NotNull(message = "商品ID不能为空")
    @Schema(description = "商品ID", example = "1001")
    private Integer goodsId;
    
    @Schema(description = "通用商品ID", example = "2001")
    private Integer commonId;
    
    @NotNull(message = "购买数量不能为空")
    @Positive(message = "购买数量必须大于0")
    @Schema(description = "购买数量", example = "1")
    private Integer buyNum;
    
    @Schema(description = "捆绑销售ID", example = "3001")
    private Integer bundlingId;
    
    @Schema(description = "分销订单ID", example = "4001")
    private Integer distributionOrdersId;
}