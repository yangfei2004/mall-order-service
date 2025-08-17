package com.mall.order.adapter.in.web.controller;

import com.mall.order.common.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 健康检查控制器
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/health")
@Tag(name = "健康检查", description = "服务健康检查接口")
public class HealthController {
    
    /**
     * 健康检查
     */
    @GetMapping
    @Operation(summary = "健康检查", description = "检查服务是否正常运行")
    public Result<Map<String, Object>> health() {
        Map<String, Object> healthInfo = new HashMap<>();
        healthInfo.put("status", "UP");
        healthInfo.put("service", "mall-order-service");
        healthInfo.put("timestamp", LocalDateTime.now());
        healthInfo.put("version", "1.0.0");
        
        log.debug("健康检查请求");
        return Result.success(healthInfo);
    }
}