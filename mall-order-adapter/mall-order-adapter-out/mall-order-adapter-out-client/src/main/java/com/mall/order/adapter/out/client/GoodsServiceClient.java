package com.mall.order.adapter.out.client;

import com.mall.order.adapter.out.client.dto.GoodsInfoResponse;
import com.mall.order.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 商品服务客户端
 */
@FeignClient(name = "mall-goods-service", path = "/api/v1/goods")
public interface GoodsServiceClient {
    
    /**
     * 根据商品ID查询商品信息
     */
    @GetMapping("/{goodsId}")
    Result<GoodsInfoResponse> getGoodsById(@PathVariable("goodsId") Integer goodsId);
    
    /**
     * 批量查询商品信息
     */
    @PostMapping("/batch")
    Result<List<GoodsInfoResponse>> getGoodsByIds(@RequestBody List<Integer> goodsIds);
    
    /**
     * 检查商品库存
     */
    @GetMapping("/{goodsId}/stock/{quantity}")
    Result<Boolean> checkStock(@PathVariable("goodsId") Integer goodsId, 
                              @PathVariable("quantity") Integer quantity);
    
    /**
     * 扣减商品库存
     */
    @PostMapping("/{goodsId}/stock/deduct/{quantity}")
    Result<Void> deductStock(@PathVariable("goodsId") Integer goodsId, 
                            @PathVariable("quantity") Integer quantity);
}