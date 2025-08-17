package com.mall.order.adapter.in.feign.client;

import com.mall.order.adapter.in.feign.dto.OrderFeignResponse;
import com.mall.order.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 订单服务Feign客户端
 */
@FeignClient(name = "mall-order-service", path = "/api/v1/orders")
public interface OrderFeignClient {
    
    /**
     * 根据订单ID查询订单详情
     */
    @GetMapping("/{orderId}")
    Result<OrderFeignResponse> getOrderById(@PathVariable("orderId") Long orderId);
    
    /**
     * 根据会员ID查询订单列表
     */
    @GetMapping("/member/{memberId}")
    Result<List<OrderFeignResponse>> getOrdersByMemberId(
            @PathVariable("memberId") Integer memberId,
            @RequestParam(value = "orderState", required = false) Integer orderState);
    
    /**
     * 根据订单号查询订单
     */
    @GetMapping("/sn/{orderSn}")
    Result<OrderFeignResponse> getOrderByOrderSn(@PathVariable("orderSn") Long orderSn);
}