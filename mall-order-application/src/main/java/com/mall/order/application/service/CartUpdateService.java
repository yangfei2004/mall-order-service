package com.mall.order.application.service;

import com.mall.order.application.command.UpdateCartCommand;
import com.mall.order.application.port.in.CartUpdateCase;
import com.mall.order.application.port.out.CartRepository;
import com.mall.order.common.enums.Resp;
import com.mall.order.common.exception.BusinessException;
import com.mall.order.domain.model.cart.Cart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author yangfei
 */
@Slf4j
@Service
public class CartUpdateService implements CartUpdateCase {

    private final CartRepository cartRepository;

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
}
