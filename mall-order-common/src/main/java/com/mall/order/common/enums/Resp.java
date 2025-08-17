package com.mall.order.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应状态码枚举
 * 格式：ORDER + 5位数字，总长度10位
 * 00000-00999: 通用状态码
 * 01000-01999: 订单相关
 * 02000-02999: 购物车相关
 * 03000-03999: 退款相关
 * 04000-04999: 支付相关
 * 99000-99999: 系统错误相关
 */
@Getter
@AllArgsConstructor
public enum Resp {
    // 通用状态码
    SUCCESS("ORDER00000", "success"),
    FAIL("ORDER99999", "fail"),
    BAD_REQUEST("ORDER00400", "请求错误"),
    INVALID_PARAM("ORDER00401", "非法参数"),
    JSON_FORMAT_ERROR("ORDER00402", "JSON格式错误"),
    
    // 订单相关
    ORDER_NOT_FOUND("ORDER01000", "订单不存在"),
    ORDER_STATUS_ERROR("ORDER01001", "订单状态错误"),
    ORDER_AMOUNT_ERROR("ORDER01002", "订单金额错误"),
    ORDER_CREATE_FAILED("ORDER01003", "订单创建失败"),
    ORDER_UPDATE_FAILED("ORDER01004", "订单更新失败"),
    ORDER_CANCEL_FAILED("ORDER01005", "订单取消失败"),
    ORDER_PAY_FAILED("ORDER01006", "订单支付失败"),
    ORDER_SHIP_FAILED("ORDER01007", "订单发货失败"),
    ORDER_FINISH_FAILED("ORDER01008", "订单完成失败"),
    ORDER_GOODS_NOT_FOUND("ORDER01009", "订单商品不存在"),
    ORDER_GOODS_AMOUNT_ERROR("ORDER01010", "订单商品金额错误"),
    
    // 购物车相关
    CART_ITEM_NOT_FOUND("ORDER02000", "购物车商品不存在"),
    CART_ITEM_EXISTS("ORDER02001", "购物车商品已存在"),
    CART_ITEM_ADD_FAILED("ORDER02002", "添加购物车失败"),
    CART_ITEM_UPDATE_FAILED("ORDER02003", "更新购物车失败"),
    CART_ITEM_DELETE_FAILED("ORDER02004", "删除购物车失败"),
    CART_EMPTY("ORDER02005", "购物车为空"),
    CART_GOODS_STOCK_NOT_ENOUGH("ORDER02006", "购物车商品库存不足"),
    
    // 退款相关
    REFUND_NOT_FOUND("ORDER03000", "退款记录不存在"),
    REFUND_STATUS_ERROR("ORDER03001", "退款状态错误"),
    REFUND_AMOUNT_ERROR("ORDER03002", "退款金额错误"),
    REFUND_CREATE_FAILED("ORDER03003", "退款申请失败"),
    REFUND_PROCESS_FAILED("ORDER03004", "退款处理失败"),
    REFUND_CANCEL_FAILED("ORDER03005", "退款取消失败"),
    
    // 支付相关
    PAYMENT_NOT_FOUND("ORDER04000", "支付记录不存在"),
    PAYMENT_STATUS_ERROR("ORDER04001", "支付状态错误"),
    PAYMENT_AMOUNT_ERROR("ORDER04002", "支付金额错误"),
    PAYMENT_CREATE_FAILED("ORDER04003", "支付创建失败"),
    PAYMENT_PROCESS_FAILED("ORDER04004", "支付处理失败"),
    PAYMENT_CANCEL_FAILED("ORDER04005", "支付取消失败");
    
    private final String code;
    private final String message;
}