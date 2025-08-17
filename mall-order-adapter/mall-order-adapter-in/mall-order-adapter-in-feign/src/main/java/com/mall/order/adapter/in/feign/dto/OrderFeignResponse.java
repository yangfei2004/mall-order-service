package com.mall.order.adapter.in.feign.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 订单Feign响应DTO
 */
@Data
public class OrderFeignResponse {
    
    /**
     * 订单ID
     */
    private Long ordersId;
    
    /**
     * 订单号
     */
    private Long ordersSn;
    
    /**
     * 会员ID
     */
    private Integer memberId;
    
    /**
     * 会员名称
     */
    private String memberName;
    
    /**
     * 订单状态
     */
    private Integer ordersState;
    
    /**
     * 订单类型
     */
    private Integer ordersType;
    
    /**
     * 订单金额
     */
    private BigDecimal ordersAmount;
    
    /**
     * 最终金额
     */
    private BigDecimal finalAmount;
    
    /**
     * 支付状态
     */
    private Integer paymentState;
    
    /**
     * 支付方式代码
     */
    private String paymentCode;
    
    /**
     * 收货人姓名
     */
    private String receiverName;
    
    /**
     * 收货人电话
     */
    private String receiverPhone;
    
    /**
     * 收货地址
     */
    private String receiverAddress;
    
    /**
     * 物流编码
     */
    private String shipCode;
    
    /**
     * 物流名称
     */
    private String shipName;
    
    /**
     * 物流单号
     */
    private String shipSn;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 支付时间
     */
    private LocalDateTime paymentTime;
    
    /**
     * 完成时间
     */
    private LocalDateTime finishTime;
    
    /**
     * 订单商品列表
     */
    private List<OrderGoodsFeignResponse> orderGoodsList;
    
    /**
     * 订单商品Feign响应DTO
     */
    @Data
    public static class OrderGoodsFeignResponse {
        
        /**
         * 订单商品ID
         */
        private Long orderGoodsId;
        
        /**
         * 商品ID
         */
        private Integer goodsId;
        
        /**
         * 商品名称
         */
        private String goodsName;
        
        /**
         * 商品图片
         */
        private String goodsImage;
        
        /**
         * 商品价格
         */
        private BigDecimal goodsPrice;
        
        /**
         * 购买数量
         */
        private Integer buyNum;
        
        /**
         * 商品规格
         */
        private String goodsFullSpecs;
    }
}