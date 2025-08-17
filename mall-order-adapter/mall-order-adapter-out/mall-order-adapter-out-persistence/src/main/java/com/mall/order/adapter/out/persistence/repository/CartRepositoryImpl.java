package com.mall.order.adapter.out.persistence.repository;

import com.mall.order.adapter.out.persistence.converter.CartConverter;
import com.mall.order.adapter.out.persistence.entity.CartJpaEntity;
import com.mall.order.adapter.out.persistence.mapper.CartMapper;
import com.mall.order.application.port.out.CartRepository;
import com.mall.order.domain.model.cart.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 购物车仓储实现
 */
@Repository
@RequiredArgsConstructor
public class CartRepositoryImpl implements CartRepository {
    
    private final CartMapper cartMapper;
    private final CartConverter cartConverter;
    
    @Override
    public Cart save(Cart cart) {
        CartJpaEntity entity = cartConverter.toJpaEntity(cart);
        
        if (entity.getCartId() == null) {
            cartMapper.insert(entity);
        } else {
            cartMapper.updateById(entity);
        }
        
        return cartConverter.toDomainModel(entity);
    }
    
    @Override
    public Optional<Cart> findById(Long cartId) {
        CartJpaEntity entity = cartMapper.selectById(cartId);
        return Optional.ofNullable(cartConverter.toDomainModel(entity));
    }
    
    @Override
    public List<Cart> findByMemberId(Integer memberId) {
        List<CartJpaEntity> entities = cartMapper.findByMemberId(memberId);
        return entities.stream()
                .map(cartConverter::toDomainModel)
                .collect(Collectors.toList());
    }
    
    @Override
    public Optional<Cart> findByMemberIdAndGoodsId(Integer memberId, Integer goodsId) {
        CartJpaEntity entity = cartMapper.findByMemberIdAndGoodsId(memberId, goodsId);
        return Optional.ofNullable(cartConverter.toDomainModel(entity));
    }
    
    @Override
    public void deleteById(Long cartId) {
        cartMapper.deleteById(cartId);
    }
    
    @Override
    public void deleteByMemberId(Integer memberId) {
        cartMapper.deleteByMemberId(memberId);
    }
    
    @Override
    public boolean existsById(Long cartId) {
        return cartMapper.selectById(cartId) != null;
    }
}