package com.mall.order.adapter.in.web.handlers;

import com.mall.order.common.Result;
import com.mall.order.common.enums.Resp;
import com.mall.order.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.Set;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Result<Object> handleBusinessException(BusinessException e) {
        Resp resp = e.getResp();
        if (resp == null) {
            log.info("业务异常（无枚举）：{}", e.getMessage());
            return Result.fail(Result.HTTP_OK, "ORDER99000", e.getMessage(), null);
        }
        
        log.info("业务异常：{}", resp.getMessage());
        return Result.fail(Result.HTTP_OK, resp.getCode(), resp.getMessage(), null);
    }

    /**
     * 处理参数校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        String message = fieldError != null ? fieldError.getDefaultMessage() : "参数校验失败";
        log.warn("参数校验异常：{}", message);
        return Result.fail(Result.HTTP_BAD_REQUEST, Resp.INVALID_PARAM.getCode(), message, null);
    }

    /**
     * 处理约束违反异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<Object> handleConstraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        String message = violations.iterator().next().getMessage();
        log.warn("约束违反异常：{}", message);
        return Result.fail(Result.HTTP_BAD_REQUEST, Resp.INVALID_PARAM.getCode(), message, null);
    }

    /**
     * 处理绑定异常
     */
    @ExceptionHandler(BindException.class)
    public Result<Object> handleBindException(BindException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        String message = fieldError != null ? fieldError.getDefaultMessage() : "参数绑定失败";
        log.warn("参数绑定异常：{}", message);
        return Result.fail(Result.HTTP_BAD_REQUEST, Resp.INVALID_PARAM.getCode(), message, null);
    }

    /**
     * 处理缺少请求参数异常
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        String message = "缺少必需的请求参数: " + e.getParameterName();
        log.warn("缺少请求参数异常：{}", message);
        return Result.fail(Result.HTTP_BAD_REQUEST, Resp.INVALID_PARAM.getCode(), message, null);
    }

    /**
     * 处理类型不匹配异常
     */
    @ExceptionHandler(TypeMismatchException.class)
    public Result<Object> handleTypeMismatchException(TypeMismatchException e) {
        String message = "参数类型不匹配: " + e.getValue();
        log.warn("类型不匹配异常：{}", message);
        return Result.fail(Result.HTTP_BAD_REQUEST, Resp.INVALID_PARAM.getCode(), message, null);
    }

    /**
     * 处理HTTP消息不可读异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.warn("HTTP消息不可读异常：{}", e.getMessage());
        return Result.fail(Result.HTTP_BAD_REQUEST, Resp.JSON_FORMAT_ERROR.getCode(), 
                          Resp.JSON_FORMAT_ERROR.getMessage(), null);
    }

    /**
     * 处理不支持的HTTP方法异常
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        String message = "不支持的HTTP方法: " + e.getMethod();
        log.warn("不支持的HTTP方法异常：{}", message);
        return Result.fail(Result.HTTP_BAD_REQUEST, Resp.BAD_REQUEST.getCode(), message, null);
    }

    /**
     * 处理不支持的媒体类型异常
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Result<Object> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        String message = "不支持的媒体类型: " + e.getContentType();
        log.warn("不支持的媒体类型异常：{}", message);
        return Result.fail(Result.HTTP_BAD_REQUEST, Resp.BAD_REQUEST.getCode(), message, null);
    }

    /**
     * 处理不可接受的媒体类型异常
     */
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public Result<Object> handleHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException e) {
        String message = "不可接受的媒体类型";
        log.warn("不可接受的媒体类型异常：{}", message);
        return Result.fail(Result.HTTP_BAD_REQUEST, Resp.BAD_REQUEST.getCode(), message, null);
    }

    /**
     * 处理缺少路径变量异常
     */
    @ExceptionHandler(MissingPathVariableException.class)
    public Result<Object> handleMissingPathVariableException(MissingPathVariableException e) {
        String message = "缺少路径变量: " + e.getVariableName();
        log.warn("缺少路径变量异常：{}", message);
        return Result.fail(Result.HTTP_BAD_REQUEST, Resp.INVALID_PARAM.getCode(), message, null);
    }

    /**
     * 处理Servlet请求绑定异常
     */
    @ExceptionHandler(ServletRequestBindingException.class)
    public Result<Object> handleServletRequestBindingException(ServletRequestBindingException e) {
        log.warn("Servlet请求绑定异常：{}", e.getMessage());
        return Result.fail(Result.HTTP_BAD_REQUEST, Resp.BAD_REQUEST.getCode(), 
                          "请求绑定失败", null);
    }

    /**
     * 处理转换不支持异常
     */
    @ExceptionHandler(ConversionNotSupportedException.class)
    public Result<Object> handleConversionNotSupportedException(ConversionNotSupportedException e) {
        log.error("转换不支持异常：{}", e.getMessage(), e);
        return Result.fail(Result.HTTP_INTERNAL_ERROR, Resp.FAIL.getCode(), 
                          "服务器内部错误", null);
    }

    /**
     * 处理缺少Servlet请求部分异常
     */
    @ExceptionHandler(MissingServletRequestPartException.class)
    public Result<Object> handleMissingServletRequestPartException(MissingServletRequestPartException e) {
        String message = "缺少请求部分: " + e.getRequestPartName();
        log.warn("缺少Servlet请求部分异常：{}", message);
        return Result.fail(Result.HTTP_BAD_REQUEST, Resp.INVALID_PARAM.getCode(), message, null);
    }

    /**
     * 处理没有找到处理器异常
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result<Object> handleNoHandlerFoundException(NoHandlerFoundException e) {
        String message = "请求的资源不存在: " + e.getRequestURL();
        log.warn("没有找到处理器异常：{}", message);
        return Result.fail(Result.HTTP_NOT_FOUND, "ORDER00404", message, null);
    }

    /**
     * 处理异步请求超时异常
     */
    @ExceptionHandler(AsyncRequestTimeoutException.class)
    public Result<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException e) {
        log.warn("异步请求超时异常：{}", e.getMessage());
        return Result.fail(Result.HTTP_INTERNAL_ERROR, "ORDER00408", "请求超时", null);
    }

    /**
     * 处理通用异常
     */
    @ExceptionHandler(Exception.class)
    public Result<Object> handleException(Exception e) {
        log.error("系统异常：{}", e.getMessage(), e);
        return Result.fail(Result.HTTP_INTERNAL_ERROR, Resp.FAIL.getCode(), 
                          "系统繁忙，请稍后重试", null);
    }
}