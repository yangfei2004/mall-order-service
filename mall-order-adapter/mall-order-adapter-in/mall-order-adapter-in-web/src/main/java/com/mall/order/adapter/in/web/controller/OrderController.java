package com.mall.order.adapter.in.web.controller;

import com.mall.order.application.command.CreateOrderCommand;
import com.mall.order.application.dto.OrderResponse;
import com.mall.order.application.port.in.CreateOrderUseCase;
import com.mall.order.application.port.in.QueryOrderUseCase;
import com.mall.order.application.query.OrderQuery;
import com.mall.order.common.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
 * 订单控制器
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Validated
@Tag(name = "订单管理", description = "订单相关接口")
public class OrderController {
    
    private final CreateOrderUseCase createOrderUseCase;
    private final QueryOrderUseCase queryOrderUseCase;
    
    /**
     * 创建订单
     */
    @PostMapping
    @Operation(summary = "创建订单", description = "根据购物车信息创建订单")
    public Result<OrderResponse> createOrder(
            @Valid @RequestBody CreateOrderCommand command) {
        log.info("创建订单请求: {}", command);
        OrderResponse response = createOrderUseCase.createOrder(command);
        return Result.success(response);
    }
    
    /**
     * 根据订单ID查询订单详情
     */
    @GetMapping("/{orderId}")
    @Operation(summary = "查询订单详情", description = "根据订单ID查询订单详情")
    public Result<OrderResponse> getOrderById(
            @Parameter(description = "订单ID") @PathVariable Long orderId) {
        log.info("查询订单详情: orderId={}", orderId);
        OrderResponse response = queryOrderUseCase.getOrderById(orderId);
        return Result.success(response);
    }
    
    /**
     * 根据会员ID查询订单列表
     */
    @GetMapping("/member/{memberId}")
    @Operation(summary = "查询会员订单列表", description = "根据会员ID查询订单列表")
    public Result<List<OrderResponse>> getOrdersByMemberId(
            @Parameter(description = "会员ID") @PathVariable Integer memberId,
            @Parameter(description = "订单状态") @RequestParam(required = false) Integer orderState,
            @Parameter(description = "页码") @RequestParam(defaultValue = "1") Integer page,
            @Parameter(description = "页大小") @RequestParam(defaultValue = "10") Integer size) {
        log.info("查询会员订单列表: memberId={}, orderState={}, page={}, size={}", 
                memberId, orderState, page, size);
        
        OrderQuery query = new OrderQuery();
        query.setMemberId(memberId);
        query.setOrderState(orderState);
        query.setPage(page);
        query.setSize(size);
        
        List<OrderResponse> responses = queryOrderUseCase.getOrdersByQuery(query);
        return Result.success(responses);
    }
    
    /**
     * 根据订单号查询订单
     */
    @GetMapping("/sn/{orderSn}")
    @Operation(summary = "根据订单号查询订单", description = "根据订单号查询订单详情")
    public Result<OrderResponse> getOrderByOrderSn(
            @Parameter(description = "订单号") @PathVariable Long orderSn) {
        log.info("根据订单号查询订单: orderSn={}", orderSn);
        OrderResponse response = queryOrderUseCase.getOrderByOrderSn(orderSn);
        return Result.success(response);
    }
    
    /**
     * 取消订单
     */
    @PutMapping("/{orderId}/cancel")
    @Operation(summary = "取消订单", description = "取消指定订单")
    public Result<Void> cancelOrder(
            @Parameter(description = "订单ID") @PathVariable Long orderId,
            @Parameter(description = "取消原因") @RequestParam String cancelReason) {
        log.info("取消订单: orderId={}, cancelReason={}", orderId, cancelReason);
        // TODO: 实现取消订单逻辑
        return Result.success();
    }
    
    /**
     * 确认收货
     */
    @PutMapping("/{orderId}/confirm")
    @Operation(summary = "确认收货", description = "确认收货完成订单")
    public Result<Void> confirmOrder(
            @Parameter(description = "订单ID") @PathVariable Long orderId) {
        log.info("确认收货: orderId={}", orderId);
        // TODO: 实现确认收货逻辑
        return Result.success();
    }
}