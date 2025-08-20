package com.mall.order.domain.model.order;

import com.mall.order.common.enums.Resp;
import com.mall.order.common.exception.BusinessException;

import java.math.BigDecimal;

public record FinalAmount (BigDecimal finalAmount){
    public FinalAmount{
        if(finalAmount==null||finalAmount.compareTo(BigDecimal.ZERO)<0){
            throw new BusinessException(Resp.ORDER_AMOUNT_ERROR);
        }

    }
    public BigDecimal getValue(){
        return this.finalAmount;
    }
}
