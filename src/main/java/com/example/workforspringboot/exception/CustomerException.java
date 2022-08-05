package com.example.workforspringboot.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: CustomerException
 * @Description: TODO
 * @Author: liujianfu
 * @Date: 2021/03/26 11:39:01
 * @Version: V1.0
 **/

@RestControllerAdvice  //@ControllerAdvice 如果是返回json数据 则用 RestControllerAdvice,就可以不加 @ResponseBody
public class CustomerException {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerException.class);
    //捕获全局异常,处理所有不可知的异常
    @ExceptionHandler(value=Exception.class)
    Object handleException(Exception e, HttpServletRequest request){
        LOG.error("url {}, msg {}",request.getRequestURL(), e.getMessage());
        Map<String, Object> map = new HashMap<>();
        map.put("code", 400);
        map.put("msg", "错误信息如下："+e.getMessage());
        map.put("url", "请求地址："+request.getRequestURL());
        return map;
    }
}


