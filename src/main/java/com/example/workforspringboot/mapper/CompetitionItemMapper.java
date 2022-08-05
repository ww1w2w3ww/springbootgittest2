package com.example.workforspringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.example.workforspringboot.entity.CompetitionItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CompetitionItemMapper extends BaseMapper<CompetitionItem> {

    @Select("select * from competition_item ")
    CompetitionItem find();
}
