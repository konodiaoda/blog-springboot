package com.wjh.blog.exception;

import com.wjh.blog.constant.StatusConstEnum;
import com.wjh.blog.enums.StatusCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wujiahui
 * @description
 * @date 2021-10-22 12:52
 */
@Getter
@AllArgsConstructor
public class BizException extends RuntimeException {
    /**
     * 错误码
     */
    private Integer code = StatusConstEnum.FAIL.getCode();

    /**
     * 错误信息
     */
    private final String message;

    public BizException(String message) {
        this.message = message;
    }

    public BizException(StatusCodeEnum statusCodeEnum) {
        this.code = statusCodeEnum.getCode();
        this.message = statusCodeEnum.getDesc();

    }
}
