package com.mall.order.application.service;

import com.mall.order.application.dto.OrderResponse;
import com.mall.order.application.port.in.QueryOrderUseCase;
import com.mall.order.application.port.out.OrderRepository;
import com.mall.order.application.query.OrderQuery;
import com.mall.order.common.enums.Resp;
import com.mall.order.common.exception.BusinessException;
import com.mall.order.domain.model.order.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 查询订单服务
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class QueryOrderService implements QueryOrderUseCase {
    
    private final OrderRepository orderRepository;
    


    
    /**
     * 转换为响应对象
     */
    private OrderResponse convertToResponse(Order order) {
        OrderResponse response = new OrderResponse();
        response.setOrdersId(order.getOrdersId());
        response.setOrdersSn(order.getOrdersSn());
        response.setMemberId(order.getMemberId());
        response.setMemberName(order.getMemberName());
        response.setOrdersState(order.getOrdersState());
        response.setOrdersType(order.getOrdersType());
        response.setOrdersAmount(order.getOrdersAmount());
        response.setFinalAmount(order.getFinalAmount());
        response.setPaymentState(order.getPaymentState());
        response.setPaymentCode(order.getPaymentCode());
        response.setReceiverName(order.getReceiverName());
        response.setReceiverPhone(order.getReceiverPhone());
        response.setReceiverAddress(order.getReceiverAddress());
        response.setReceiverAreaInfo(order.getReceiverAreaInfo());
        response.setReceiverMessage(order.getReceiverMessage());
        response.setShipCode(order.getShipCode());
        response.setShipName(order.getShipName());
        response.setShipSn(order.getShipSn());
        response.setOrdersNote(order.getOrdersNote());
        response.setCreateTime(order.getCreateTime());
        response.setPaymentTime(order.getPaymentTime());
        response.setFinishTime(order.getFinishTime());
        
        // 转换订单商品列表
        if (order.getOrderGoodsList() != null) {
            List<OrderResponse.OrderGoodsResponse> orderGoodsResponses = order.getOrderGoodsList().stream()
                    .map(this::convertOrderGoodsToResponse)
                    .collect(Collectors.toList());
            response.setOrderGoodsList(orderGoodsResponses);
        }
        
        return response;
    }
    
    /**
     * 转换订单商品为响应对象
     */
    private OrderResponse.OrderGoodsResponse convertOrderGoodsToResponse(com.mall.order.domain.model.order.OrderGoods orderGoods) {
        OrderResponse.OrderGoodsResponse response = new OrderResponse.OrderGoodsResponse();
        response.setOrderGoodsId(orderGoods.getOrderGoodsId());
        response.setGoodsId(orderGoods.getGoodsId());
        response.setGoodsName(orderGoods.getGoodsName());
        response.setGoodsImage(orderGoods.getGoodsImage());
        response.setGoodsPrice(orderGoods.getGoodsPrice());
        response.setBuyNum(orderGoods.getBuyNum());
        response.setGoodsFullSpecs(orderGoods.getGoodsFullSpecs());
        response.setCategoryId(orderGoods.getCategoryId());
        response.setStoreId(orderGoods.getStoreId());
        response.setGoodsSerial(orderGoods.getGoodsSerial());
        response.setUnitName(orderGoods.getUnitName());
        return response;
    }
}