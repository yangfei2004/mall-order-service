package com.mall.order.domain.model.order;

import com.mall.order.common.enums.Resp;
import com.mall.order.common.exception.BusinessException;

import java.math.BigDecimal;

public record CouponAmount(BigDecimal couponAmount) {
    public CouponAmount{
        if(couponAmount==null){
            throw new BusinessException(Resp.ORDER_COUPON_AMOUNT_ERROR);
        }
    }

    public BigDecimal getValue() {
        return this.couponAmount;
    }
}
