package com.mall.order.application.service;

import com.mall.order.application.command.AddToCartCommand;
import com.mall.order.application.port.in.CartAddCase;
import com.mall.order.application.port.out.CartRepository;
import com.mall.order.domain.model.cart.Cart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Slf4j
@Service
public class CartAddService implements CartAddCase {

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
}
