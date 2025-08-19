package com.mall.order.application.port.out;

import com.mall.order.domain.model.order.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 订单仓储接口
 */
@Repository
public interface OrderRepository {
    
    /**
     * 保存订单
     * @param order 订单
     * @return 保存后的订单
     */
    Order save(Order order);
    
    /**
     * 根据ID查找订单
     * @param orderId 订单ID
     * @return 订单
     */
    Optional<Order> findById(Long orderId);
    
    /**
     * 根据订单号查找订单
     * @param ordersSn 订单号
     * @return 订单
     */
    Optional<Order> findByOrdersSn(Long ordersSn);
    
    /**
     * 根据用户ID查找订单列表
     * @param memberId 用户ID
     * @param ordersState 订单状态（可选）
     * @return 订单列表
     */
    List<Order> findByMemberId(Integer memberId, Integer ordersState);

    List<Order> findByMemberId(Integer memberId);

    /**
     * 删除订单
     * @param orderId 订单ID
     */
    void deleteById(Long orderId);
    List<Order> findByOrdersState(Integer ordersState);
    public List<Order> findByStoreId(Integer storeId);
    public boolean existsByOrdersSn(Long ordersSn);
}