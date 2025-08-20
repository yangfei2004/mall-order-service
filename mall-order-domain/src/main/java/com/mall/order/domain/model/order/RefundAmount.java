package com.mall.order.domain.model.order;

import com.mall.order.common.enums.Resp;
import com.mall.order.common.exception.BusinessException;

import java.math.BigDecimal;

public record RefundAmount(BigDecimal refundAmount,BigDecimal finalAmount) {
    public RefundAmount{
        if(refundAmount==null||refundAmount.compareTo(BigDecimal.ZERO)<0||refundAmount.compareTo(finalAmount)>0){
            throw new BusinessException(Resp.REFUND_AMOUNT_ERROR);
        }
    }


    public BigDecimal getRefundAmount(){
        return refundAmount;
    }
}
