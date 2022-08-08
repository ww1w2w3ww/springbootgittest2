package com.example.workforspringboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.workforspringboot.entity.Admin;

import java.util.List;

//
public interface AdminService extends IService<Admin> {

    List<Admin> listAdmin(String account);

    Page<Admin> pagelistAdmin(int current,int size);

    boolean insertAdmin(Admin admin);
    boolean updateAdmin(String account, String password);
    boolean deleteAdmin(String account);
    String login(Admin admin);

    boolean poi(Admin admin);
    boolean poiWord();
    boolean hutoolExcel();
/*    boolean hutoolExcel2();*/
}