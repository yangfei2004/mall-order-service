package com.mall.order.adapter.out.client.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品信息响应DTO
 */
@Data
public class GoodsInfoResponse {
    
    /**
     * 商品ID
     */
    private Integer goodsId;
    
    /**
     * 通用商品ID
     */
    private Integer commonId;
    
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
     * 商品库存
     */
    private Integer goodsStock;
    
    /**
     * 商品规格
     */
    private String goodsFullSpecs;
    
    /**
     * 商品编号
     */
    private String goodsSerial;
    
    /**
     * 商品分类ID
     */
    private Integer categoryId;
    
    /**
     * 店铺ID
     */
    private Integer storeId;
    
    /**
     * 单位名称
     */
    private String unitName;
    
    /**
     * 商品状态
     */
    private Integer goodsState;
}