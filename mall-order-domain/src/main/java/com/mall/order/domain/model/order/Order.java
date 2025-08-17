package com.mall.order.domain.model.order;

import com.mall.order.common.exception.BusinessException;
import com.mall.order.common.enums.Resp;
import com.mall.order.domain.event.OrderCreatedEvent;
import com.mall.order.domain.event.OrderStatusChangedEvent;
import com.mall.order.domain.event.DomainEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单聚合根
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Order {
    
    private Long ordersId;
    private Long ordersSn;
    private Integer memberId;
    private String memberName;
    private Integer ordersState;
    private Integer ordersType;
    private BigDecimal ordersAmount;
    private BigDecimal finalAmount;
    private BigDecimal freightAmount;
    private BigDecimal couponAmount;
    private BigDecimal preDepositAmount;
    private BigDecimal refundAmount;
    private String ordersFrom;
    private LocalDateTime createTime;
    private LocalDateTime paymentTime;
    private LocalDateTime sendTime;
    private LocalDateTime finishTime;
    private LocalDateTime cancelTime;
    private String cancelReason;
    private Integer cancelRole;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private String receiverAreaInfo;
    private String receiverMessage;
    private String paymentCode;
    private String paymentTypeCode;
    private String shipCode;
    private String shipName;
    private String shipSn;
    private String ordersNote;
    private Integer storeId;
    private String storeName;
    private Integer lockState;
    private Integer deleteState;
    private Integer evaluationState;
    private LocalDateTime evaluationTime;
    private Integer refundState;
    private String invoiceTitle;
    private String invoiceContent;
    private String invoiceCode;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
    private Integer isDeleted;
    
    // 订单商品列表
    private List<OrderGoods> orderGoodsList = new ArrayList<>();
    
    // 领域事件列表
    private List<DomainEvent> domainEvents = new ArrayList<>();
    
    /**
     * 订单状态枚举
     */
    public enum OrderState {
        PENDING_PAYMENT(10, "待付款"),
        PENDING_SHIPMENT(20, "待发货"),
        PENDING_RECEIPT(30, "待收货"),
        COMPLETED(40, "已完成"),
        CANCELLED(50, "已取消"),
        REFUNDING(60, "退款中"),
        REFUNDED(70, "已退款");
        
        private final Integer code;
        private final String description;
        
        OrderState(Integer code, String description) {
            this.code = code;
            this.description = description;
        }
        
        public Integer getCode() {
            return code;
        }
        
        public String getDescription() {
            return description;
        }
        
        public static OrderState fromCode(Integer code) {
            for (OrderState state : values()) {
                if (state.code.equals(code)) {
                    return state;
                }
            }
            throw new BusinessException(Resp.ORDER_STATUS_ERROR);
        }
    }
    
    /**
     * 创建订单
     */
    public static Order create(Long ordersSn, Integer memberId, String memberName, 
                              BigDecimal ordersAmount, String receiverName, String receiverPhone, 
                              String receiverAddress, List<OrderGoods> orderGoodsList) {
        Order order = new Order();
        order.ordersSn = ordersSn;
        order.memberId = memberId;
        order.memberName = memberName;
        order.ordersAmount = ordersAmount;
        order.finalAmount = ordersAmount;
        order.ordersState = OrderState.PENDING_PAYMENT.getCode();
        order.ordersType = 1; // 普通订单
        order.receiverName = receiverName;
        order.receiverPhone = receiverPhone;
        order.receiverAddress = receiverAddress;
        order.createTime = LocalDateTime.now();
        order.lockState = 0;
        order.deleteState = 0;
        order.evaluationState = 0;
        order.refundState = 0;
        order.isDeleted = 0;
        order.orderGoodsList = orderGoodsList != null ? orderGoodsList : new ArrayList<>();
        
        // 发布订单创建事件
        order.addDomainEvent(new OrderCreatedEvent(order.ordersSn, order.memberId, order.ordersAmount));
        
        return order;
    }
    
    /**
     * 支付订单
     */
    public void pay(String paymentCode, String paymentTypeCode) {
        if (!OrderState.PENDING_PAYMENT.getCode().equals(this.ordersState)) {
            throw new BusinessException(Resp.ORDER_CANNOT_PAY);
        }
        
        Integer oldState = this.ordersState;
        this.ordersState = OrderState.PENDING_SHIPMENT.getCode();
        this.paymentCode = paymentCode;
        this.paymentTypeCode = paymentTypeCode;
        this.paymentTime = LocalDateTime.now();
        
        // 发布订单状态变更事件
        addDomainEvent(new OrderStatusChangedEvent(this.ordersSn, oldState, this.ordersState));
    }
    
    /**
     * 发货
     */
    public void ship(String shipCode, String shipName, String shipSn) {
        if (!OrderState.PENDING_SHIPMENT.getCode().equals(this.ordersState)) {
            throw new BusinessException(Resp.ORDER_CANNOT_SHIP);
        }
        
        Integer oldState = this.ordersState;
        this.ordersState = OrderState.PENDING_RECEIPT.getCode();
        this.shipCode = shipCode;
        this.shipName = shipName;
        this.shipSn = shipSn;
        this.sendTime = LocalDateTime.now();
        
        // 发布订单状态变更事件
        addDomainEvent(new OrderStatusChangedEvent(this.ordersSn, oldState, this.ordersState));
    }
    
    /**
     * 确认收货
     */
    public void receive() {
        if (!OrderState.PENDING_RECEIPT.getCode().equals(this.ordersState)) {
            throw new BusinessException(Resp.ORDER_CANNOT_RECEIVE);
        }
        
        Integer oldState = this.ordersState;
        this.ordersState = OrderState.COMPLETED.getCode();
        this.finishTime = LocalDateTime.now();
        
        // 发布订单状态变更事件
        addDomainEvent(new OrderStatusChangedEvent(this.ordersSn, oldState, this.ordersState));
    }
    
    /**
     * 取消订单
     */
    public void cancel(String cancelReason, Integer cancelRole) {
        if (OrderState.COMPLETED.getCode().equals(this.ordersState) || 
            OrderState.CANCELLED.getCode().equals(this.ordersState)) {
            throw new BusinessException(Resp.ORDER_CANNOT_CANCEL);
        }
        
        Integer oldState = this.ordersState;
        this.ordersState = OrderState.CANCELLED.getCode();
        this.cancelReason = cancelReason;
        this.cancelRole = cancelRole;
        this.cancelTime = LocalDateTime.now();
        
        // 发布订单状态变更事件
        addDomainEvent(new OrderStatusChangedEvent(this.ordersSn, oldState, this.ordersState));
    }
    
    /**
     * 计算订单总金额
     */
    public void calculateAmount() {
        BigDecimal goodsAmount = orderGoodsList.stream()
                .map(goods -> goods.getGoodsPrice().multiply(BigDecimal.valueOf(goods.getBuyNum())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        this.ordersAmount = goodsAmount;
        this.finalAmount = goodsAmount
                .add(freightAmount != null ? freightAmount : BigDecimal.ZERO)
                .subtract(couponAmount != null ? couponAmount : BigDecimal.ZERO)
                .subtract(preDepositAmount != null ? preDepositAmount : BigDecimal.ZERO);
        
        if (this.finalAmount.compareTo(BigDecimal.ZERO) < 0) {
            this.finalAmount = BigDecimal.ZERO;
        }
    }
    
    /**
     * 添加领域事件
     */
    private void addDomainEvent(DomainEvent event) {
        this.domainEvents.add(event);
    }
    
    /**
     * 获取并清空领域事件
     */
    public List<DomainEvent> getDomainEventsAndClear() {
        List<DomainEvent> events = new ArrayList<>(this.domainEvents);
        this.domainEvents.clear();
        return events;
    }
}