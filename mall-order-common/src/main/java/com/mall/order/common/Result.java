package com.mall.order.common;

import com.mall.order.common.enums.Resp;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * 统一响应结果类
 * @param <T> 响应数据类型
 */
@Data
@Accessors(chain = true) // 启用链式调用
public class Result<T> implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 1L;
    
    /**
     * 常用HTTP状态码
     */
    public static final int HTTP_OK = 200;
    public static final int HTTP_BAD_REQUEST = 400;
    public static final int HTTP_UNAUTHORIZED = 401;
    public static final int HTTP_FORBIDDEN = 403;
    public static final int HTTP_NOT_FOUND = 404;
    public static final int HTTP_INTERNAL_ERROR = 500;
    
    /**
     * HTTP状态码
     */
    private Integer status;
    
    /**
     * 业务状态码
     */
    private String code;
    
    /**
     * 响应消息
     */
    private String msg;
    
    /**
     * 响应数据
     */
    private T data;
    
    /**
     * 前端跳转路径
     */
    private String path;
    
    /**
     * 响应时间戳
     */
    private Long timestamp;
    
    /**
     * 请求跟踪ID，用于日志追踪
     */
    private String traceId;
    
    /**
     * 附加信息，用于存储不适合放在主要字段中的额外信息
     */
    private java.util.Map<String, Object> extra;
    
    /**
     * 默认构造函数，初始化时间戳和跟踪ID
     */
    public Result() {
        this.timestamp = System.currentTimeMillis();
        this.traceId = generateTraceId();
    }
    
    /**
     * 生成请求跟踪ID
     * @return 唯一的跟踪ID
     */
    private String generateTraceId() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }
    
    /**
     * 判断响应是否成功
     * @return 是否成功
     */
    public boolean isSuccess() {
        return Resp.SUCCESS.getCode().equals(this.code);
    }
    
    /**
     * 判断响应是否失败
     * @return 是否失败
     */
    public boolean isError() {
        return !isSuccess();
    }

    /**
     * 创建成功响应
     * @param status HTTP状态码
     * @param code 业务状态码
     * @param msg 响应消息
     * @param data 响应数据
     * @param path 前端跳转路径
     * @return 响应结果
     */
    public static <T> Result<T> success(Integer status, String code, String msg, T data, String path) {
        Result<T> result = new Result<>();
        result.setStatus(status);
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        result.setPath(path);
        return result;
    }

    /**
     * 创建成功响应（带数据和跳转路径）
     * @param data 响应数据
     * @param path 前端跳转路径
     * @return 响应结果
     */
    public static <T> Result<T> success(T data, String path) {
        return success(HTTP_OK, Resp.SUCCESS.getCode(), Resp.SUCCESS.getMessage(), data, path);
    }

    /**
     * 创建成功响应（带数据）
     * @param data 响应数据
     * @return 响应结果
     */
    public static <T> Result<T> success(T data) {
        return success(HTTP_OK, Resp.SUCCESS.getCode(), Resp.SUCCESS.getMessage(), data, null);
    }

    /**
     * 创建成功响应（无数据）
     * @return 响应结果
     */
    public static <T> Result<T> success() {
        return success(HTTP_OK, Resp.SUCCESS.getCode(), Resp.SUCCESS.getMessage(), null, null);
    }

    /**
     * 创建失败响应
     * @param status HTTP状态码
     * @param code 业务状态码
     * @param msg 响应消息
     * @param path 前端跳转路径
     * @return 响应结果
     */
    public static <T> Result<T> fail(Integer status, String code, String msg, String path) {
        Result<T> result = new Result<>();
        result.setStatus(status);
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        result.setPath(path);
        return result;
    }

    /**
     * 创建失败响应（默认）
     * @return 响应结果
     */
    public static <T> Result<T> fail() {
        return fail(HTTP_INTERNAL_ERROR, Resp.FAIL.getCode(), Resp.FAIL.getMessage(), null);
    }

    /**
     * 创建失败响应（基于响应枚举）
     * @param resp 响应枚举
     * @return 响应结果
     */
    public static <T> Result<T> fail(Resp resp) {
        return fail(HTTP_INTERNAL_ERROR, resp.getCode(), resp.getMessage(), null);
    }

    /**
     * 创建失败响应（基于响应枚举，自定义消息）
     * @param resp 响应枚举
     * @param message 自定义消息
     * @return 响应结果
     */
    public static <T> Result<T> fail(Resp resp, String message) {
        return fail(HTTP_INTERNAL_ERROR, resp.getCode(), message, null);
    }

    /**
     * 创建失败响应（基于响应枚举，带跳转路径）
     * @param resp 响应枚举
     * @param message 自定义消息
     * @param path 前端跳转路径
     * @return 响应结果
     */
    public static <T> Result<T> fail(Resp resp, String message, String path) {
        return fail(HTTP_INTERNAL_ERROR, resp.getCode(), message, path);
    }

    /**
     * 创建失败响应（自定义消息）
     * @param message 自定义消息
     * @return 响应结果
     */
    public static <T> Result<T> fail(String message) {
        return fail(HTTP_INTERNAL_ERROR, Resp.FAIL.getCode(), message, null);
    }

    /**
     * 创建失败响应（自定义状态码和消息）
     * @param status HTTP状态码
     * @param message 自定义消息
     * @return 响应结果
     */
    public static <T> Result<T> fail(Integer status, String message) {
        return fail(status, Resp.FAIL.getCode(), message, null);
    }

    /**
     * 添加附加信息
     * @param key 键
     * @param value 值
     * @return 当前对象，支持链式调用
     */
    public Result<T> addExtra(String key, Object value) {
        if (this.extra == null) {
            this.extra = new java.util.HashMap<>();
        }
        this.extra.put(key, value);
        return this;
    }

    /**
     * 设置跟踪ID
     * @param traceId 跟踪ID
     * @return 当前对象，支持链式调用
     */
    public Result<T> withTraceId(String traceId) {
        this.traceId = traceId;
        return this;
    }

    /**
     * 设置路径
     * @param path 路径
     * @return 当前对象，支持链式调用
     */
    public Result<T> withPath(String path) {
        this.path = path;
        return this;
    }
}