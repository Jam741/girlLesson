package com.ngls.girl.exception;

public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
