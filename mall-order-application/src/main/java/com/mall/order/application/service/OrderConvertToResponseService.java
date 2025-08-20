package com.mall.order.application.service;

import com.mall.order.application.dto.OrderResponse;
import com.mall.order.domain.model.order.Order;
import com.mall.order.domain.model.order.OrderGoods;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderConvertToResponseService {
    /**
     *
     *转换订单为响应对象
     * 转换为响应对象
     * @author yangfei
     */
    public OrderResponse convertToResponse(Order order) {
        OrderResponse response = new OrderResponse();
        response.setOrdersId(order.getOrdersId());
        response.setOrdersSn(order.getOrdersSn());
        response.setMemberId(order.getMemberId());
        response.setMemberName(order.getMemberName());
        response.setOrdersState(order.getOrdersState());
        response.setOrdersType(order.getOrdersType());
        response.setOrdersAmount(order.getOrdersAmount());
        response.setFinalAmount(order.getFinalAmount());
        response.setPaymentState(order.getOrdersState());
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
     * @author yangfei
     */
    public OrderResponse.OrderGoodsResponse convertOrderGoodsToResponse(OrderGoods orderGoods) {
        OrderResponse.OrderGoodsResponse response = new OrderResponse.OrderGoodsResponse();
        response.setOrdersGoodsId(orderGoods.getOrdersGoodsId());
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
