package com.mall.order.adapter.out.client.dto;

import lombok.Data;

/**
 * 会员信息响应DTO
 */
@Data
public class MemberInfoResponse {
    
    /**
     * 会员ID
     */
    private Integer memberId;
    
    /**
     * 会员名称
     */
    private String memberName;
    
    /**
     * 会员手机号
     */
    private String memberMobile;
    
    /**
     * 会员邮箱
     */
    private String memberEmail;
    
    /**
     * 会员状态
     */
    private Integer memberState;
    
    /**
     * 会员等级
     */
    private Integer memberGrade;
}