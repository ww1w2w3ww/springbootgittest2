package com.example.workforspringboot.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.workforspringboot.entity.Admin;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JsonListUtil {
    //admin:list实体类转换成map
    public static  List<Map<String,Object>> EntityConvertMap(List<Admin> list){
        List<Map<String,Object>> l = new LinkedList<>();
        try {
            for(Admin t : list){
                Map<String,Object> map = new HashMap<>();
                Method[] methods = t.getClass().getMethods();
                for (Method method : methods) {
                    if (method.getName().startsWith("get")) {
                        String name = method.getName().substring(3);
                        name = name.substring(0, 1).toLowerCase() + name.substring(1);
                        Object value = method.invoke(t);
                        map.put(name,value);
                    }
                }
                l.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }


}
