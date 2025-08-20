package com.mall.order.domain.model.order;

import com.mall.order.common.enums.Resp;
import com.mall.order.common.exception.BusinessException;

import java.math.BigDecimal;

public record FreightAmount (BigDecimal freightAmount){
    public FreightAmount{
        if(freightAmount==null){
            throw new BusinessException(Resp.ORDER_FREIGHT_AMOUNT_ERROR);
        }
    }
    public BigDecimal getValue(){
        return this.freightAmount;
    }


}
