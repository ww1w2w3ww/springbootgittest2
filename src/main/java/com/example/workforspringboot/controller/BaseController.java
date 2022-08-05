package com.example.workforspringboot.controller;

import com.alibaba.fastjson.JSON;
import com.example.workforspringboot.codeEnum.RestCodeEnum;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public abstract class BaseController {
    public static final String CODE = "code";
    public static final String MSG = "msg";
    public static final String DATA = "data";

    protected static String success() {
        final Map<String, Object> result = Maps.newHashMap();
        result.put(CODE, RestCodeEnum.SUCCESS.getCode());
        result.put(MSG, RestCodeEnum.SUCCESS.getMsg());
        return JSON.toJSONString(result);
    }

    protected static String success(Object data) {
        final Map<String, Object> result = Maps.newHashMap();
        result.put(CODE, RestCodeEnum.SUCCESS.getCode());
        result.put(MSG, RestCodeEnum.SUCCESS.getMsg());
        result.put(DATA, data);
        return JSON.toJSONString(result);
    }

    protected static String error(RestCodeEnum code) {
        final Map<String, Object> result = Maps.newHashMap();
        result.put(CODE, code.getCode());
        result.put(MSG, code.getMsg());
        return JSON.toJSONString(result);
    }

    protected static String error(RestCodeEnum code, String msg) {
        final Map<String, Object> result = Maps.newHashMap();
        result.put(CODE, code.getCode());
        result.put(MSG, msg);
        return JSON.toJSONString(result);
    }
}