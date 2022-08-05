package com.example.workforspringboot.handler;

import com.example.workforspringboot.controller.BaseController;
import com.example.workforspringboot.exception.RestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends BaseController {
//    *
//     * 基础异常

    @ExceptionHandler(RestException.class)
    public String baseException(RestException e) {
        return error(e.getRetCode(), e.getMessage());
    }
}