package com.mall.order.adapter.out.persistence.converter;

import com.mall.order.adapter.out.persistence.entity.CartJpaEntity;
import com.mall.order.domain.model.cart.Cart;
import org.springframework.stereotype.Component;

/**
 * 购物车转换器
 */
@Component
public class CartConverter {

    /**
     * 领域对象转JPA实体
     */
    public CartJpaEntity toJpaEntity(Cart cart) {
        if (cart == null) {
            return null;
        }

        CartJpaEntity entity = new CartJpaEntity();
        entity.setCartId(cart.getCartId());
        entity.setMemberId(cart.getMemberId());
        entity.setGoodsId(cart.getGoodsId());
        entity.setCommonId(cart.getCommonId());
        entity.setBuyNum(cart.getBuyNum());
        entity.setBundlingId(cart.getBundlingId());
        entity.setDistributionOrdersId(cart.getDistributionOrdersId());
        entity.setCreatedAt(cart.getCreatedAt());
        entity.setCreatedBy(cart.getCreatedBy());
        entity.setUpdatedAt(cart.getUpdatedAt());
        entity.setUpdatedBy(cart.getUpdatedBy());
        entity.setIsDeleted(cart.getIsDeleted());

        return entity;
    }

    /**
     * JPA实体转领域对象
     */
    public Cart toDomainModel(CartJpaEntity entity) {
        if (entity == null) {
            return null;
        }

        Cart cart = new Cart();
        cart.setCartId(entity.getCartId());
        cart.setMemberId(entity.getMemberId());
        cart.setGoodsId(entity.getGoodsId());
        cart.setCommonId(entity.getCommonId());
        cart.setBuyNum(entity.getBuyNum());
        cart.setBundlingId(entity.getBundlingId());
        cart.setDistributionOrdersId(entity.getDistributionOrdersId());
        cart.setCreatedAt(entity.getCreatedAt());
        cart.setCreatedBy(entity.getCreatedBy());
        cart.setUpdatedAt(entity.getUpdatedAt());
        cart.setUpdatedBy(entity.getUpdatedBy());
        cart.setIsDeleted(entity.getIsDeleted());

        return cart;
    }
}