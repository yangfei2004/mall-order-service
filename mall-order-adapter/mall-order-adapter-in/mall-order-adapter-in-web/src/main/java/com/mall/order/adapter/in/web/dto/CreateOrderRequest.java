package com.mall.order.adapter.in.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

/**
 * 创建订单请求DTO
 */
@Data
@Schema(description = "创建订单请求")
public class CreateOrderRequest {
    
    @NotNull(message = "会员ID不能为空")
    @Schema(description = "会员ID", example = "1001")
    private Integer memberId;
    
    @Schema(description = "会员名称", example = "张三")
    private String memberName;
    
    @NotNull(message = "收货人姓名不能为空")
    @Schema(description = "收货人姓名", example = "李四")
    private String receiverName;
    
    @NotNull(message = "收货人电话不能为空")
    @Schema(description = "收货人电话", example = "13800138000")
    private String receiverPhone;
    
    @NotNull(message = "收货地址不能为空")
    @Schema(description = "收货地址", example = "北京市朝阳区xxx街道xxx号")
    private String receiverAddress;
    
    @Schema(description = "收货地区信息", example = "北京市-朝阳区")
    private String receiverAreaInfo;
    
    @Schema(description = "收货留言", example = "请放在门卫处")
    private String receiverMessage;
    
    @Schema(description = "支付方式代码", example = "alipay")
    private String paymentCode;
    
    @Schema(description = "订单备注", example = "尽快发货")
    private String ordersNote;
    
    @NotEmpty(message = "订单商品列表不能为空")
    @Valid
    @Schema(description = "订单商品列表")
    private List<OrderGoodsRequest> orderGoodsList;
    
    /**
     * 订单商品请求DTO
     */
    @Data
    @Schema(description = "订单商品")
    public static class OrderGoodsRequest {
        
        @NotNull(message = "商品ID不能为空")
        @Schema(description = "商品ID", example = "1001")
        private Integer goodsId;
        
        @Schema(description = "通用商品ID", example = "2001")
        private Integer commonId;
        
        @NotNull(message = "商品名称不能为空")
        @Schema(description = "商品名称", example = "iPhone 15 Pro")
        private String goodsName;
        
        @Schema(description = "商品图片", example = "https://example.com/image.jpg")
        private String goodsImage;
        
        @Schema(description = "商品规格", example = "256GB 深空黑色")
        private String goodsFullSpecs;
        
        @NotNull(message = "商品价格不能为空")
        @Positive(message = "商品价格必须大于0")
        @Schema(description = "商品价格", example = "8999.00")
        private BigDecimal goodsPrice;
        
        @NotNull(message = "购买数量不能为空")
        @Positive(message = "购买数量必须大于0")
        @Schema(description = "购买数量", example = "1")
        private Integer buyNum;
        
        @Schema(description = "商品分类ID", example = "101")
        private Integer categoryId;
        
        @Schema(description = "店铺ID", example = "1001")
        private Integer storeId;
        
        @Schema(description = "商品编号", example = "SKU001")
        private String goodsSerial;
        
        @Schema(description = "单位名称", example = "台")
        private String unitName;
    }
}