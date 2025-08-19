package com.mall.order.application.service;

import com.mall.order.application.dto.CartResponse;
import com.mall.order.application.port.in.GetCartByMemberIdCase;
import com.mall.order.application.port.out.CartRepository;
import com.mall.order.domain.model.cart.Cart;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
/**
 *
 * @author yangfei
 */
@Service
public class GetCartByMemberIdService implements GetCartByMemberIdCase {

    private final CartRepository cartRepository;

    public GetCartByMemberIdService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public List<CartResponse> getCartByMemberId(Integer memberId) {
        List<Cart> carts = cartRepository.findByMemberId(memberId);
        return carts.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }
    /**
     * 转换为响应对象
     */
    private CartResponse convertToResponse(Cart cart) {
        CartResponse response = new CartResponse();
        response.setCartId(cart.getCartId());
        response.setMemberId(cart.getMemberId());
        response.setGoodsId(cart.getGoodsId());
        response.setCommonId(cart.getCommonId());
        response.setBuyNum(cart.getBuyNum());
        response.setBundlingId(cart.getBundlingId());
        response.setDistributionOrdersId(cart.getDistributionOrdersId());
        response.setCreatedAt(cart.getCreatedAt());
        response.setUpdatedAt(cart.getUpdatedAt());
        return response;
    }
}
