package com.mall.order.domain.model.cart;

import com.mall.order.common.exception.BusinessException;
import com.mall.order.common.enums.Resp;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 购物车领域模型
 */
@Data
public class Cart {
    
    private Long cartId;
    private Integer memberId;
    private Integer goodsId;
    private Integer commonId;
    private Integer buyNum;
    private Integer bundlingId;
    private Integer distributionOrdersId;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
    private Integer isDeleted;
    
    /**
     * 创建购物车项
     */
    public static Cart create(Integer memberId, Integer goodsId, Integer commonId, 
                             Integer buyNum, Integer bundlingId, Integer distributionOrdersId) {
        if (memberId == null || memberId <= 0) {
            throw new BusinessException(Resp.INVALID_PARAM);
        }
        if (goodsId == null || goodsId <= 0) {
            throw new BusinessException(Resp.INVALID_PARAM);
        }
        if (buyNum == null || buyNum <= 0) {
            throw new BusinessException(Resp.INVALID_PARAM);
        }
        
        Cart cart = new Cart();
        cart.memberId = memberId;
        cart.goodsId = goodsId;
        cart.commonId = commonId;
        cart.buyNum = buyNum;
        cart.bundlingId = bundlingId;
        cart.distributionOrdersId = distributionOrdersId;
        cart.createdAt = LocalDateTime.now();
        cart.updatedAt = LocalDateTime.now();
        cart.isDeleted = 0;
        
        return cart;
    }
    
    /**
     * 更新购买数量
     */
    public void updateBuyNum(Integer newBuyNum) {
        if (newBuyNum == null || newBuyNum <= 0) {
            throw new BusinessException(Resp.INVALID_PARAM);
        }
        
        this.buyNum = newBuyNum;
        this.updatedAt = LocalDateTime.now();
    }
}