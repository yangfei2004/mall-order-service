package com.mall.order.common.util;

import com.github.yitter.idgen.YitIdHelper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 订单号生成器
 */
@Component
public class OrderSnGenerator {
    
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");
    
    /**
     * 生成订单号
     * 格式：日期(8位) + 雪花ID(13位)
     * @return 订单号
     */
    public Long generateOrderSn() {
        String dateStr = LocalDateTime.now().format(DATE_FORMAT);
        long snowflakeId = YitIdHelper.nextId();
        // 取雪花ID的后13位
        long suffix = snowflakeId % 10000000000000L;
        return Long.parseLong(dateStr + String.format("%013d", suffix));
    }
    
    /**
     * 生成支付单号
     * 格式：日期(8位) + 随机数(12位)
     * @return 支付单号
     */
    public Long generatePaySn() {
        String dateStr = LocalDateTime.now().format(DATE_FORMAT);
        long randomNum = ThreadLocalRandom.current().nextLong(100000000000L, 999999999999L);
        return Long.parseLong(dateStr + randomNum);
    }
    
    /**
     * 生成退款单号
     * 格式：日期(8位) + 随机数(12位)
     * @return 退款单号
     */
    public Long generateRefundSn() {
        String dateStr = LocalDateTime.now().format(DATE_FORMAT);
        long randomNum = ThreadLocalRandom.current().nextLong(100000000000L, 999999999999L);
        return Long.parseLong(dateStr + randomNum);
    }
}