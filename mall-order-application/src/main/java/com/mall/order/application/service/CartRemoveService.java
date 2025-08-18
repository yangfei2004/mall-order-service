package com.mall.order.application.service;

import com.mall.order.application.port.in.CartRemoveCase;
import com.mall.order.application.port.out.CartRepository;
import com.mall.order.common.enums.Resp;
import com.mall.order.common.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author yangfei
 */
@Service
public class CartRemoveService implements CartRemoveCase {

    private final CartRepository cartRepository;

    @Override
    @Transactional
    public void removeFromCart(Long cartId) {
        if (!cartRepository.existsById(cartId)) {
            throw new BusinessException(Resp.CART_ITEM_NOT_FOUND);
        }

        cartRepository.deleteById(cartId);
        log.info("商品已从购物车删除，购物车ID：{}", cartId);
    }
}
