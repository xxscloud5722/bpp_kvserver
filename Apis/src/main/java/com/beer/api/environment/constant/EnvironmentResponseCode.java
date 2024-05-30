package com.beer.api.environment.constant;

import com.billbear.common.base.exception.ResponseCodeException;
import lombok.Getter;

/**
 * @author 橘猫.
 */
@Getter
public enum EnvironmentResponseCode implements ResponseCodeException {
    /**
     * 数据已存在.
     */
    EXIST("数据已存在"),

    /**
     * 服务器内部错误.
     */
    FAIL("10015", "服务器内部错误");

    private final String code;
    private String message;

    EnvironmentResponseCode(String message) {
        this.code = "500";
        this.message = message;
    }

    EnvironmentResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public EnvironmentResponseCode message(String message) {
        this.message = message;
        return this;
    }
}
