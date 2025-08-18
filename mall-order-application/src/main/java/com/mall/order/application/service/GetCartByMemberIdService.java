package com.mall.order.application.service;

import com.mall.order.application.dto.CartResponse;
import com.mall.order.application.port.in.GetCartByMemberIdCase;
import com.mall.order.application.port.out.CartRepository;
import com.mall.order.domain.model.cart.Cart;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetCartByMemberIdService implements GetCartByMemberIdCase {

    private final CartRepository cartRepository;

    @Override
    public List<CartResponse> getCartByMemberId(Integer memberId) {
        List<Cart> carts = cartRepository.findByMemberId(memberId);
        return carts.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }
}
