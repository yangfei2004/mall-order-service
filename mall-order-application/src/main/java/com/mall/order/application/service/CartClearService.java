package com.mall.order.application.service;

import com.mall.order.application.port.in.CartClearCase;
import com.mall.order.application.port.out.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class CartClearService implements CartClearCase {


    private final CartRepository CartRepository;

    @Override
    @Transactional
    public void clearCart(Integer memberId) {
        cartRepository.deleteByMemberId(memberId);
        log.info("购物车已清空，会员ID：{}", memberId);
    }

}
