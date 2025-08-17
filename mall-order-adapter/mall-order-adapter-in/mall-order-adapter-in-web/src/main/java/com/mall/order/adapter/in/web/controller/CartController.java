package com.mall.order.adapter.in.web.controller;

import com.mall.order.application.command.AddToCartCommand;
import com.mall.order.application.command.UpdateCartCommand;
import com.mall.order.application.dto.CartResponse;
import com.mall.order.application.port.in.CartUseCase;
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
 * 购物车控制器
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@Validated
@Tag(name = "购物车管理", description = "购物车相关接口")
public class CartController {
    
    private final CartUseCase cartUseCase;
    
    /**
     * 添加商品到购物车
     */
    @PostMapping
    @Operation(summary = "添加商品到购物车", description = "将商品添加到购物车")
    public Result<Void> addToCart(@Valid @RequestBody AddToCartCommand command) {
        log.info("添加商品到购物车: {}", command);
        cartUseCase.addToCart(command);
        return Result.success();
    }
    
    /**
     * 查询购物车列表
     */
    @GetMapping("/member/{memberId}")
    @Operation(summary = "查询购物车列表", description = "根据会员ID查询购物车商品列表")
    public Result<List<CartResponse>> getCartByMemberId(
            @Parameter(description = "会员ID") @PathVariable Integer memberId) {
        log.info("查询购物车列表: memberId={}", memberId);
        List<CartResponse> responses = cartUseCase.getCartByMemberId(memberId);
        return Result.success(responses);
    }
    
    /**
     * 更新购物车商品数量
     */
    @PutMapping("/{cartId}")
    @Operation(summary = "更新购物车商品数量", description = "更新购物车中商品的数量")
    public Result<Void> updateCartQuantity(
            @Parameter(description = "购物车ID") @PathVariable Long cartId,
            @Parameter(description = "商品数量") @RequestParam Integer quantity) {
        log.info("更新购物车商品数量: cartId={}, quantity={}", cartId, quantity);
        
        UpdateCartCommand command = new UpdateCartCommand();
        command.setCartId(cartId);
        command.setBuyNum(quantity);
        
        cartUseCase.updateCart(command);
        return Result.success();
    }
    
    /**
     * 删除购物车商品
     */
    @DeleteMapping("/{cartId}")
    @Operation(summary = "删除购物车商品", description = "从购物车中删除指定商品")
    public Result<Void> removeFromCart(
            @Parameter(description = "购物车ID") @PathVariable Long cartId) {
        log.info("删除购物车商品: cartId={}", cartId);
        cartUseCase.removeFromCart(cartId);
        return Result.success();
    }
    
    /**
     * 清空购物车
     */
    @DeleteMapping("/member/{memberId}")
    @Operation(summary = "清空购物车", description = "清空指定会员的购物车")
    public Result<Void> clearCart(
            @Parameter(description = "会员ID") @PathVariable Integer memberId) {
        log.info("清空购物车: memberId={}", memberId);
        cartUseCase.clearCart(memberId);
        return Result.success();
    }
}