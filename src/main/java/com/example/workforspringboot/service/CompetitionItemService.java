package com.example.workforspringboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.workforspringboot.entity.Admin;
import com.example.workforspringboot.entity.CompetitionItem;

import java.util.List;

public interface CompetitionItemService extends IService<CompetitionItem> {
    List<CompetitionItem> listItem(String content);
    boolean insertItem(CompetitionItem competitionItem);
    boolean updateItem(String phone, String opinion, String status);
    boolean deleteItem(String phone);
    Page<CompetitionItem> pagelistItem(int current, int size);
}
