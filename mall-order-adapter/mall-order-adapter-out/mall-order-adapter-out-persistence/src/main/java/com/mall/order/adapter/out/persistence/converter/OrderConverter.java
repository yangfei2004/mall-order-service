package com.mall.order.adapter.out.persistence.converter;

import com.mall.order.adapter.out.persistence.entity.OrderJpaEntity;
import com.mall.order.domain.model.order.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * 订单转换器
 */
@Component
public class OrderConverter {
    
    /**
     * 领域对象转JPA实体
     */
    public OrderJpaEntity toJpaEntity(Order order) {
        if (order == null) {
            return null;
        }
        
        OrderJpaEntity entity = new OrderJpaEntity();
        entity.setOrdersId(order.getOrdersId());
        entity.setOrdersSn(order.getOrdersSn());
        entity.setMemberId(order.getMemberId());
        entity.setMemberName(order.getMemberName());
        entity.setOrdersState(order.getOrdersState());
        entity.setOrdersType(order.getOrdersType());
        entity.setOrdersAmount(order.getOrdersAmount());
        entity.setFinalAmount(order.getFinalAmount());
        entity.setFreightAmount(order.getFreightAmount());
        entity.setCouponAmount(order.getCouponAmount());
        entity.setPreDepositAmount(order.getPreDepositAmount());
        entity.setRefundAmount(order.getRefundAmount());
        entity.setOrdersFrom(order.getOrdersFrom());
        entity.setCreateTime(order.getCreateTime());
        entity.setPaymentTime(order.getPaymentTime());
        entity.setSendTime(order.getSendTime());
        entity.setFinishTime(order.getFinishTime());
        entity.setCancelTime(order.getCancelTime());
        entity.setCancelReason(order.getCancelReason());
        entity.setCancelRole(order.getCancelRole());
        entity.setReceiverName(order.getReceiverName());
        entity.setReceiverPhone(order.getReceiverPhone());
        entity.setReceiverAddress(order.getReceiverAddress());
        entity.setReceiverAreaInfo(order.getReceiverAreaInfo());
        entity.setReceiverMessage(order.getReceiverMessage());
        entity.setPaymentCode(order.getPaymentCode());
        entity.setPaymentTypeCode(order.getPaymentTypeCode());
        entity.setShipCode(order.getShipCode());
        entity.setShipName(order.getShipName());
        entity.setShipSn(order.getShipSn());
        entity.setOrdersNote(order.getOrdersNote());
        entity.setStoreId(order.getStoreId());
        entity.setStoreName(order.getStoreName());
        entity.setLockState(order.getLockState());
        entity.setDeleteState(order.getDeleteState());
        entity.setEvaluationState(order.getEvaluationState());
        entity.setEvaluationTime(order.getEvaluationTime());
        entity.setRefundState(order.getRefundState());
        entity.setInvoiceTitle(order.getInvoiceTitle());
        entity.setInvoiceContent(order.getInvoiceContent());
        entity.setInvoiceCode(order.getInvoiceCode());
        entity.setCreatedAt(order.getCreatedAt());
        entity.setCreatedBy(order.getCreatedBy());
        entity.setUpdatedAt(order.getUpdatedAt());
        entity.setUpdatedBy(order.getUpdatedBy());
        entity.setIsDeleted(order.getIsDeleted());
        
        return entity;
    }
    
    /**
     * JPA实体转领域对象
     */
    public Order toDomainModel(OrderJpaEntity entity) {
        if (entity == null) {
            return null;
        }
        
        Order order = new Order();
        order.setOrdersId(entity.getOrdersId());
        order.setOrdersSn(entity.getOrdersSn());
        order.setMemberId(entity.getMemberId());
        order.setMemberName(entity.getMemberName());
        order.setOrdersState(entity.getOrdersState());
        order.setOrdersType(entity.getOrdersType());
        order.setOrdersAmount(entity.getOrdersAmount());
        order.setFinalAmount(entity.getFinalAmount());
        order.setFreightAmount(entity.getFreightAmount());
        order.setCouponAmount(entity.getCouponAmount());
        order.setPreDepositAmount(entity.getPreDepositAmount());
        order.setRefundAmount(entity.getRefundAmount());
        order.setOrdersFrom(entity.getOrdersFrom());
        order.setCreateTime(entity.getCreateTime());
        order.setPaymentTime(entity.getPaymentTime());
        order.setSendTime(entity.getSendTime());
        order.setFinishTime(entity.getFinishTime());
        order.setCancelTime(entity.getCancelTime());
        order.setCancelReason(entity.getCancelReason());
        order.setCancelRole(entity.getCancelRole());
        order.setReceiverName(entity.getReceiverName());
        order.setReceiverPhone(entity.getReceiverPhone());
        order.setReceiverAddress(entity.getReceiverAddress());
        order.setReceiverAreaInfo(entity.getReceiverAreaInfo());
        order.setReceiverMessage(entity.getReceiverMessage());
        order.setPaymentCode(entity.getPaymentCode());
        order.setPaymentTypeCode(entity.getPaymentTypeCode());
        order.setShipCode(entity.getShipCode());
        order.setShipName(entity.getShipName());
        order.setShipSn(entity.getShipSn());
        order.setOrdersNote(entity.getOrdersNote());
        order.setStoreId(entity.getStoreId());
        order.setStoreName(entity.getStoreName());
        order.setLockState(entity.getLockState());
        order.setDeleteState(entity.getDeleteState());
        order.setEvaluationState(entity.getEvaluationState());
        order.setEvaluationTime(entity.getEvaluationTime());
        order.setRefundState(entity.getRefundState());
        order.setInvoiceTitle(entity.getInvoiceTitle());
        order.setInvoiceContent(entity.getInvoiceContent());
        order.setInvoiceCode(entity.getInvoiceCode());
        order.setCreatedAt(entity.getCreatedAt());
        order.setCreatedBy(entity.getCreatedBy());
        order.setUpdatedAt(entity.getUpdatedAt());
        order.setUpdatedBy(entity.getUpdatedBy());
        order.setIsDeleted(entity.getIsDeleted());
        
        // 初始化订单商品列表和领域事件列表
        order.setOrderGoodsList(new ArrayList<>());
        order.setDomainEvents(new ArrayList<>());
        
        return order;
    }
}