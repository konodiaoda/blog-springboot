package com.wjh.blog.common;

import com.wjh.blog.constant.StatusConstEnum;
import lombok.Data;

/**
 * @author wujiahui
 * @description
 * @date 2021-09-13 23:51
 */
@Data
public class Result<T>{
    /**
     * 返回状态
     */
    private Boolean flag;
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    public static <T> Result<T> ok() {
        return restResult(true, null, StatusConstEnum.SUCCESS.getCode(), StatusConstEnum.SUCCESS.getDesc());
    }

    public static <T> Result<T> ok(T data) {
        return restResult(true, data, StatusConstEnum.SUCCESS.getCode(), StatusConstEnum.SUCCESS.getDesc());
    }

    public static <T> Result<T> ok(T data, String message) {
        return restResult(true, data, StatusConstEnum.SUCCESS.getCode(), message);
    }

    public static <T> Result<T> fail() {
        return restResult(false, null, StatusConstEnum.FAIL.getCode(),StatusConstEnum.FAIL.getDesc());
    }

    public static <T> Result<T> fail(StatusConstEnum statusCodeEnum) {
        return restResult(false, null, statusCodeEnum.getCode(), statusCodeEnum.getDesc());
    }

    public static <T> Result<T> fail(String message) {
        return restResult(false, message);
    }

    public static <T> Result<T> fail(T data) {
        return restResult(false, data, StatusConstEnum.FAIL.getCode(), StatusConstEnum.FAIL.getDesc());
    }

    public static <T> Result<T> fail(T data, String message) {
        return restResult(false, data, StatusConstEnum.FAIL.getCode(), message);
    }

    public static <T> Result<T> fail(Integer code, String message) {
        return restResult(false, null, code, message);
    }

    private static <T> Result<T> restResult(Boolean flag, String message) {
        Result<T> apiResult = new Result<>();
        apiResult.setFlag(flag);
        apiResult.setCode(flag ? StatusConstEnum.SUCCESS.getCode() : StatusConstEnum.FAIL.getCode());
        apiResult.setMessage(message);
        return apiResult;
    }

    private static <T> Result<T> restResult(Boolean flag, T data, Integer code, String message) {
        Result<T> apiResult = new Result<>();
        apiResult.setFlag(flag);
        apiResult.setData(data);
        apiResult.setCode(code);
        apiResult.setMessage(message);
        return apiResult;
    }
}

