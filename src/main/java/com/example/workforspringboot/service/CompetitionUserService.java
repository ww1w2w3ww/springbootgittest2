package com.example.workforspringboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.workforspringboot.entity.CompetitionItem;
import com.example.workforspringboot.entity.CompetitionUser;

import java.util.List;

public interface CompetitionUserService extends IService<CompetitionUser> {
    List<CompetitionUser> listUser(String name);
    boolean insertUser(CompetitionUser competitionUser);
    boolean updateUser(String phone, String companyName);
    boolean deleteUser(String phone);
    Page<CompetitionUser> pagelistUser(int current, int size);
}
