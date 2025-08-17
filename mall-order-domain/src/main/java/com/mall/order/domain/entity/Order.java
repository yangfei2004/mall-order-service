package com.mall.order.domain.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单实体类
 */
@Data
public class Order {
    private Long id;
    private String orderNo; // 订单编号
    private Long memberId; // 会员ID
    private String memberName; // 会员名称
    private BigDecimal totalAmount; // 订单总金额
    private BigDecimal payAmount; // 应付金额
    private BigDecimal freightAmount; // 运费
    private BigDecimal discountAmount; // 优惠金额
    private Integer payType; // 支付方式
    private Integer sourceType; // 订单来源
    private Integer status; // 订单状态
    private Integer orderType; // 订单类型
    private String receiverName; // 收货人姓名
    private String receiverPhone; // 收货人电话
    private String receiverAddress; // 收货人地址
    private String note; // 订单备注
    private Date createTime; // 创建时间
    private Date paymentTime; // 支付时间
    private Date deliveryTime; // 发货时间
    private Date receiveTime; // 收货时间
    private Date modifyTime; // 修改时间
}
