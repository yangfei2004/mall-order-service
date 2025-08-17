package com.mall.order.application.service;

import com.mall.order.application.command.AddToCartCommand;
import com.mall.order.application.command.UpdateCartCommand;
import com.mall.order.application.dto.CartResponse;
import com.mall.order.application.port.in.CartUseCase;
import com.mall.order.application.port.out.CartRepository;
import com.mall.order.common.exception.BusinessException;
import com.mall.order.common.enums.Resp;
import com.mall.order.domain.model.cart.Cart;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 购物车服务实现
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CartService implements CartUseCase {
    
    private final CartRepository cartRepository;
    
    @Override
    @Transactional
    public void addToCart(AddToCartCommand command) {
        // 检查是否已存在相同商品
        Optional<Cart> existingCart = cartRepository.findByMemberIdAndGoodsId(
                command.getMemberId(), command.getGoodsId());
        
        if (existingCart.isPresent()) {
            // 更新数量
            Cart cart = existingCart.get();
            cart.updateBuyNum(cart.getBuyNum() + command.getBuyNum());
            cartRepository.save(cart);
        } else {
            // 创建新的购物车项
            Cart cart = Cart.create(
                    command.getMemberId(),
                    command.getGoodsId(),
                    command.getCommonId(),
                    command.getBuyNum(),
                    command.getBundlingId(),
                    command.getDistributionOrdersId()
            );
            cartRepository.save(cart);
        }
        
        log.info("商品已添加到购物车，会员ID：{}，商品ID：{}，数量：{}", 
                command.getMemberId(), command.getGoodsId(), command.getBuyNum());
    }
    
    @Override
    @Transactional
    public void updateCart(UpdateCartCommand command) {
        Cart cart = cartRepository.findById(command.getCartId())
                .orElseThrow(() -> new BusinessException(Resp.CART_ITEM_NOT_FOUND));
        
        cart.updateBuyNum(command.getBuyNum());
        cartRepository.save(cart);
        
        log.info("购物车商品数量已更新，购物车ID：{}，新数量：{}", 
                command.getCartId(), command.getBuyNum());
    }
    
    @Override
    @Transactional
    public void removeFromCart(Long cartId) {
        if (!cartRepository.existsById(cartId)) {
            throw new BusinessException(Resp.CART_ITEM_NOT_FOUND);
        }
        
        cartRepository.deleteById(cartId);
        log.info("商品已从购物车删除，购物车ID：{}", cartId);
    }
    
    @Override
    public List<CartResponse> getCartByMemberId(Integer memberId) {
        List<Cart> carts = cartRepository.findByMemberId(memberId);
        return carts.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }
    
    @Override
    @Transactional
    public void clearCart(Integer memberId) {
        cartRepository.deleteByMemberId(memberId);
        log.info("购物车已清空，会员ID：{}", memberId);
    }
    
    /**
     * 转换为响应对象
     */
    private CartResponse convertToResponse(Cart cart) {
        CartResponse response = new CartResponse();
        response.setCartId(cart.getCartId());
        response.setMemberId(cart.getMemberId());
        response.setGoodsId(cart.getGoodsId());
        response.setCommonId(cart.getCommonId());
        response.setBuyNum(cart.getBuyNum());
        response.setBundlingId(cart.getBundlingId());
        response.setDistributionOrdersId(cart.getDistributionOrdersId());
        response.setCreatedAt(cart.getCreatedAt());
        response.setUpdatedAt(cart.getUpdatedAt());
        return response;
    }
}