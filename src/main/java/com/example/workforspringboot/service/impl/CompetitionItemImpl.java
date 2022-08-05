package com.example.workforspringboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workforspringboot.entity.Admin;
import com.example.workforspringboot.entity.CompetitionItem;
import com.example.workforspringboot.mapper.CompetitionItemMapper;
import com.example.workforspringboot.service.CompetitionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompetitionItemImpl extends ServiceImpl<CompetitionItemMapper, CompetitionItem> implements CompetitionItemService {
    @Autowired
    private CompetitionItemMapper competitionItemMapper;
    @Override
    public List<CompetitionItem> listItem(String content) {
        QueryWrapper<CompetitionItem> wrapper=new QueryWrapper<>();
        wrapper.eq("content",content);
        List<CompetitionItem> competitionItems=list(wrapper);
        return competitionItems;
    }

    @Override
    public boolean insertItem(CompetitionItem competitionItem) {
        this.save(competitionItem);
        return true;
    }

    @Override
    public boolean updateItem(String content, String opinion, String status) {
        QueryWrapper<CompetitionItem> wrapper=new QueryWrapper<>();
        wrapper.eq("content",content);
        CompetitionItem item = new CompetitionItem();
        item.setOpinion(opinion);
        item.setStatus(status);
        this.update(item,wrapper);
        return true;
    }

    @Override
    public boolean deleteItem(String phone) {
        QueryWrapper<CompetitionItem> wrapper=new QueryWrapper<>();
        wrapper.eq("phone",phone);
        this.remove(wrapper);
        return true;
    }

    @Override
    public Page<CompetitionItem> pagelistItem(int current, int size) {
        Page<CompetitionItem> page = new Page<>(current, size);
        Page<CompetitionItem> ItemPage = competitionItemMapper.selectPage(page, null);
        //System.out.println(adminPage.getTotal());
        return ItemPage;
    }
}
