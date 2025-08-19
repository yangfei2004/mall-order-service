package com.mall.order.application.service;

import com.mall.order.application.command.CreateOrderCommand;
import com.mall.order.application.dto.OrderResponse;
import com.mall.order.application.port.in.CreateOrderUseCase;
import com.mall.order.application.port.out.OrderRepository;
import com.mall.order.common.util.OrderSnGenerator;
import com.mall.order.domain.model.order.Order;
import com.mall.order.domain.model.order.OrderGoods;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 创建订单服务
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CreateOrderService implements CreateOrderUseCase {
    
    private final OrderRepository orderRepository;
    private final OrderSnGenerator orderSnGenerator;


    
    @Override
    @Transactional
    public OrderResponse createOrder(CreateOrderCommand command) {
        log.info("开始创建订单，用户ID：{}", command.getMemberId());

        // 生成订单号
        Long ordersSn = orderSnGenerator.generateOrderSn();

        // 创建订单商品列表
        List<OrderGoods> orderGoodsList = command.getOrderGoodsList().stream()
                .map(goodsCommand -> OrderGoods.create(
                        goodsCommand.getGoodsId(),
                        goodsCommand.getCommonId(),
                        goodsCommand.getGoodsName(),
                        goodsCommand.getGoodsImage(),
                        goodsCommand.getGoodsPrice(),
                        goodsCommand.getBuyNum()
                ))
                .collect(Collectors.toList());

        // 计算订单总金额
        java.math.BigDecimal totalAmount = orderGoodsList.stream()
                .map(OrderGoods::getTotalAmount)
                .reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add);

        // 创建订单
        Order order = Order.create(
                ordersSn,
                command.getMemberId(),
                command.getMemberName(),
                totalAmount,
                command.getReceiverName(),
                command.getReceiverPhone(),
                command.getReceiverAddress(),
                orderGoodsList
        );

        // 设置其他订单信息
        order.setReceiverAreaInfo(command.getReceiverAreaInfo());
        order.setReceiverMessage(command.getReceiverMessage());
        order.setFreightAmount(command.getFreightAmount());
        order.setCouponAmount(command.getCouponAmount());
        order.setInvoiceTitle(command.getInvoiceTitle());
        order.setInvoiceContent(command.getInvoiceContent());
        order.setOrdersNote(command.getOrdersNote());

        // 重新计算最终金额
        order.calculateAmount();

        // 保存订单
        Order savedOrder = orderRepository.save(order);

        log.info("订单创建成功，订单号：{}", savedOrder.getOrdersSn());

        // 转换为响应DTO
        return convertToResponse(savedOrder);
    }
    private OrderResponse convertToResponse(Order order) {
        OrderResponse response = new OrderResponse();
        response.setOrdersId(order.getOrdersId());
        response.setOrdersSn(order.getOrdersSn());
        response.setMemberId(order.getMemberId());
        response.setMemberName(order.getMemberName());
        response.setOrdersState(order.getOrdersState());
        response.setOrdersStateText(Order.OrderState.fromCode(order.getOrdersState()).getDescription());
        response.setOrdersType(order.getOrdersType());
        response.setOrdersAmount(order.getOrdersAmount());
        response.setFinalAmount(order.getFinalAmount());
        response.setFreightAmount(order.getFreightAmount());
        response.setCouponAmount(order.getCouponAmount());
        response.setPreDepositAmount(order.getPreDepositAmount());
        response.setRefundAmount(order.getRefundAmount());
        response.setOrdersFrom(order.getOrdersFrom());
        response.setCreateTime(order.getCreateTime());
        response.setPaymentTime(order.getPaymentTime());
        response.setSendTime(order.getSendTime());
        response.setFinishTime(order.getFinishTime());
        response.setCancelTime(order.getCancelTime());
        response.setCancelReason(order.getCancelReason());
        response.setReceiverName(order.getReceiverName());
        response.setReceiverPhone(order.getReceiverPhone());
        response.setReceiverAddress(order.getReceiverAddress());
        response.setReceiverAreaInfo(order.getReceiverAreaInfo());
        response.setReceiverMessage(order.getReceiverMessage());
        response.setPaymentCode(order.getPaymentCode());
        response.setPaymentTypeCode(order.getPaymentTypeCode());
        response.setShipCode(order.getShipCode());
        response.setShipName(order.getShipName());
        response.setShipSn(order.getShipSn());
        response.setOrdersNote(order.getOrdersNote());
        response.setStoreId(order.getStoreId());
        response.setStoreName(order.getStoreName());
        response.setInvoiceTitle(order.getInvoiceTitle());
        response.setInvoiceContent(order.getInvoiceContent());
        response.setInvoiceCode(order.getInvoiceCode());

        // 转换订单商品列表
        if (order.getOrderGoodsList() != null) {
            List<OrderResponse.OrderGoodsResponse> goodsResponseList = order.getOrderGoodsList().stream()
                    .map(this::convertToGoodsResponse)
                    .collect(Collectors.toList());
            response.setOrderGoodsList(goodsResponseList);
        }

        return response;
    }

    private OrderResponse.OrderGoodsResponse convertToGoodsResponse(OrderGoods orderGoods) {
        OrderResponse.OrderGoodsResponse response = new OrderResponse.OrderGoodsResponse();
        response.setOrdersGoodsId(orderGoods.getOrdersGoodsId());
        response.setGoodsId(orderGoods.getGoodsId());
        response.setCommonId(orderGoods.getCommonId());
        response.setGoodsName(orderGoods.getGoodsName());
        response.setGoodsImage(orderGoods.getGoodsImage());
        response.setGoodsSerial(orderGoods.getGoodsSerial());
        response.setGoodsFullSpecs(orderGoods.getGoodsFullSpecs());
        response.setGoodsPrice(orderGoods.getGoodsPrice());
        response.setBuyNum(orderGoods.getBuyNum());
        response.setGoodsPayAmount(orderGoods.getGoodsPayAmount());
        response.setUnitName(orderGoods.getUnitName());
        response.setCategoryId(orderGoods.getCategoryId());
        response.setStoreId(orderGoods.getStoreId());
        response.setRefundPrice(orderGoods.getRefundPrice());
        return response;
    }

}