package com.example.workforspringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.workforspringboot.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
//
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    @Select("select * from admin ")
    Admin find();
}
