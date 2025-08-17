package com.mall.order.adapter.out.persistence.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mall.order.adapter.out.persistence.converter.OrderConverter;
import com.mall.order.adapter.out.persistence.entity.OrderJpaEntity;
import com.mall.order.adapter.out.persistence.mapper.OrderMapper;
import com.mall.order.application.port.out.OrderRepository;
import com.mall.order.domain.model.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 订单仓储实现
 */
@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    
    private final OrderMapper orderMapper;
    private final OrderConverter orderConverter;
    
    @Override
    public Order save(Order order) {
        OrderJpaEntity entity = orderConverter.toJpaEntity(order);
        
        if (entity.getOrdersId() == null) {
            // 新增
            orderMapper.insert(entity);
        } else {
            // 更新
            orderMapper.updateById(entity);
        }
        
        return orderConverter.toDomainModel(entity);
    }
    
    @Override
    public Optional<Order> findById(Long ordersId) {
        OrderJpaEntity entity = orderMapper.selectById(ordersId);
        return Optional.ofNullable(orderConverter.toDomainModel(entity));
    }
    
    @Override
    public Optional<Order> findByOrdersSn(Long ordersSn) {
        OrderJpaEntity entity = orderMapper.findByOrdersSn(ordersSn);
        return Optional.ofNullable(orderConverter.toDomainModel(entity));
    }
    
    @Override
    public List<Order> findByMemberId(Integer memberId) {
        List<OrderJpaEntity> entities = orderMapper.findByMemberId(memberId);
        return entities.stream()
                .map(orderConverter::toDomainModel)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Order> findByOrdersState(Integer ordersState) {
        List<OrderJpaEntity> entities = orderMapper.findByOrdersState(ordersState);
        return entities.stream()
                .map(orderConverter::toDomainModel)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Order> findByStoreId(Integer storeId) {
        List<OrderJpaEntity> entities = orderMapper.findByStoreId(storeId);
        return entities.stream()
                .map(orderConverter::toDomainModel)
                .collect(Collectors.toList());
    }
    
    @Override
    public void deleteById(Long ordersId) {
        orderMapper.deleteById(ordersId);
    }
    
    @Override
    public boolean existsByOrdersSn(Long ordersSn) {
        LambdaQueryWrapper<OrderJpaEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(OrderJpaEntity::getOrdersSn, ordersSn);
        return orderMapper.selectCount(wrapper) > 0;
    }
}