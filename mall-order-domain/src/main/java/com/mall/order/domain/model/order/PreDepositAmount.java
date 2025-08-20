package com.mall.order.domain.model.order;

import com.mall.order.common.enums.Resp;
import com.mall.order.common.exception.BusinessException;

import java.math.BigDecimal;

public record PreDepositAmount(BigDecimal preDepositAmount) {
    public PreDepositAmount{
        if(preDepositAmount==null||preDepositAmount.compareTo(BigDecimal.ZERO)<0){
            throw new BusinessException(Resp.ORDER_PRE_DEPOSIT_AMOUNT_ERROR);
        }
    }

    public BigDecimal getValue(){
        return this.preDepositAmount;
    }
}
