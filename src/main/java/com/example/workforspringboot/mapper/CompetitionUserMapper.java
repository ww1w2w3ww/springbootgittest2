package com.example.workforspringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.workforspringboot.entity.CompetitionUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CompetitionUserMapper extends BaseMapper<CompetitionUser> {

    @Select("select * from competition_user ")
    CompetitionUser find();
}
