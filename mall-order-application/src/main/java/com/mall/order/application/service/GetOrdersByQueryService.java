package com.mall.order.application.service;

import com.mall.order.application.dto.OrderResponse;
import com.mall.order.application.port.in.GetOrdersByQueryCase;
import com.mall.order.application.port.out.OrderRepository;
import com.mall.order.application.query.OrderQuery;
import com.mall.order.common.enums.Resp;
import com.mall.order.common.exception.BusinessException;
import com.mall.order.domain.model.order.Order;
import com.mall.order.domain.model.order.OrderGoods;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 查询用户订单列表
 * @param query 查询条件
 * @return 订单列表
 * @author yangfei
 */
@Slf4j
@Service
public class GetOrdersByQueryService implements GetOrdersByQueryCase {
    private final OrderRepository orderRepository;

    public GetOrdersByQueryService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public List<OrderResponse> getOrdersByQuery(OrderQuery query) {
        log.info("根据查询条件查询订单列表: {}", query);

        List<Order> orders;

        if (query.getMemberId() != null) {
            orders = orderRepository.findByMemberId(query.getMemberId());
        } else if (query.getOrderState() != null) {
            orders = orderRepository.findByOrdersState(query.getOrderState());
        } else if (query.getStoreId() != null) {
            orders = orderRepository.findByStoreId(query.getStoreId());
        } else {
            throw new BusinessException(Resp.INVALID_PARAM);
        }

        // 根据订单状态过滤
        if (query.getOrderState() != null && query.getMemberId() != null) {
            orders = orders.stream()
                    .filter(order -> query.getOrderState().equals(order.getOrdersState()))
                    .collect(Collectors.toList());
        }

        // 分页处理（简单实现，实际项目中建议使用MyBatis-Plus的分页插件）
        if (query.getPage() != null && query.getSize() != null) {
            int start = (query.getPage() - 1) * query.getSize();
            int end = Math.min(start + query.getSize(), orders.size());
            if (start < orders.size()) {
                orders = orders.subList(start, end);
            } else {
                orders = List.of();
            }
        }


        return orders.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    /**
     * 转换为响应对象
     * @author yangfei
     */
    OrderResponse convertToResponse(Order order) {
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

    /**
     * 转换订单商品为响应对象
     * @author yangfei
     */
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
