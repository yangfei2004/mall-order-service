package com.mall.order.application.port.in;

import com.mall.order.application.dto.CartResponse;

import java.util.List;

public interface GetCartByMemberIdCase {
    /**
     * 查询会员购物车
     */
    List<CartResponse> getCartByMemberId(Integer memberId);

}
