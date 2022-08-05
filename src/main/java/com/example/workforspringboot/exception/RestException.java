package com.example.workforspringboot.exception;

import com.example.workforspringboot.codeEnum.RestCodeEnum;

public class RestException extends RuntimeException {
    private static final long serialVersionUID = -649224303322031383L;

    private RestCodeEnum retCode;

    public RestException() {
        super();
    }

    public RestException(RestCodeEnum retCode) {
        super(retCode.getMsg());
        this.retCode = retCode;
    }

    public RestException(RestCodeEnum retCode, String msg) {
        super(msg);
        this.retCode = retCode;
    }

    public RestCodeEnum getRetCode() {
        return this.retCode;
    }

    public void setRetCode(RestCodeEnum retCode) {
        this.retCode = retCode;
    }
}