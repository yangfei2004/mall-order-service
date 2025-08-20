package com.mall.order.domain.model.order;

import com.mall.order.common.enums.Resp;
import com.mall.order.common.exception.BusinessException;

import java.math.BigDecimal;

public record OrdersAmount(BigDecimal ordersAmount) {
    public OrdersAmount{
        if(ordersAmount==null||ordersAmount.compareTo(BigDecimal.ZERO)<=0){
            throw new BusinessException(Resp.ORDER_AMOUNT_ERROR);
        }


    }

    public FinalAmount toFinalAmount() {
        return new FinalAmount(this.ordersAmount);
    }

    public BigDecimal getValue() {
        return this.ordersAmount;
    }

}
