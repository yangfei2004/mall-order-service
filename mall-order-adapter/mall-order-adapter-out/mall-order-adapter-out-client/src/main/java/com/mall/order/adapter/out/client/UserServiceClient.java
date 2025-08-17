package com.mall.order.adapter.out.client;

import com.mall.order.adapter.out.client.dto.MemberInfoResponse;
import com.mall.order.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户服务客户端
 */
@FeignClient(name = "mall-user-service", path = "/api/v1/members")
public interface UserServiceClient {
    
    /**
     * 根据会员ID查询会员信息
     */
    @GetMapping("/{memberId}")
    Result<MemberInfoResponse> getMemberById(@PathVariable("memberId") Integer memberId);
    
    /**
     * 验证会员是否存在
     */
    @GetMapping("/{memberId}/exists")
    Result<Boolean> memberExists(@PathVariable("memberId") Integer memberId);
}