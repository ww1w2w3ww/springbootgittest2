package com.example.workforspringboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workforspringboot.entity.CompetitionItem;
import com.example.workforspringboot.entity.CompetitionUser;
import com.example.workforspringboot.mapper.CompetitionUserMapper;
import com.example.workforspringboot.service.CompetitionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompetitionUserImpl extends ServiceImpl<CompetitionUserMapper, CompetitionUser> implements CompetitionUserService {
    @Autowired
    private CompetitionUserMapper competitionUserMapper;
    @Override
    public List<CompetitionUser> listUser(String name) {
        QueryWrapper<CompetitionUser> wrapper=new QueryWrapper<>();
        wrapper.eq("name",name);
        List<CompetitionUser> competitionUsers=list(wrapper);
        return competitionUsers;
    }

    @Override
    public boolean insertUser(CompetitionUser competitionUser) {
        this.save(competitionUser);
        return true;
    }

    @Override
    public boolean updateUser(String phone, String companyName) {
        QueryWrapper<CompetitionUser> wrapper=new QueryWrapper<>();
        wrapper.eq("phone",phone);
        CompetitionUser user = new CompetitionUser();
        user.setCompanyName(companyName);
        this.update(user,wrapper);
        return true;
    }

    @Override
    public boolean deleteUser(String phone) {
        QueryWrapper<CompetitionUser> wrapper=new QueryWrapper<>();
        wrapper.eq("phone",phone);
        this.remove(wrapper);
        return true;
    }

    @Override
    public Page<CompetitionUser> pagelistUser(int current, int size) {
        Page<CompetitionUser> page = new Page<>(current, size);
        Page<CompetitionUser> adminPage = competitionUserMapper.selectPage(page, null);
        //System.out.println(adminPage.getTotal());
        return adminPage;
    }
}
