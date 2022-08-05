package com.example.workforspringboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.workforspringboot.result.ResultData;
import com.example.workforspringboot.entity.CompetitionUser;
import com.example.workforspringboot.service.CompetitionUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "user",method = {RequestMethod.GET,RequestMethod.POST})
@Api(value = "公司相关接口", tags = {"公司相关接口"})
public class CompetitionUserController {
    @Autowired
    private CompetitionUserService userService;

    @GetMapping(value = "select")
    @ApiOperation("根据联系人手机号查找")
    public List<CompetitionUser> UserSelect(@RequestParam("name")String name){
        List<CompetitionUser> competitionUsers=userService.listUser(name);
        return competitionUsers;
    }
    @GetMapping(value = "page")
    @ApiOperation("分页查询")
    public List<CompetitionUser> ItemPageSelect(@RequestParam("current")int current, @RequestParam("size")int size){

        //Page<Admin> adminPage = adminMapper.selectPage(page, null);
        //System.out.println(adminPage.getTotal());
        //int i=1/0;
        Page<CompetitionUser> userPage=userService.pagelistUser(current,size);
        return userPage.getRecords();
    }
    @PostMapping("insert")
    @ApiOperation("插入数据")
    public ResultData UserInsert(CompetitionUser competitionUser){
        this.userService.insertUser(competitionUser);
        return ResultData.success().message(String.valueOf(true));
    }
    @PostMapping("update")
    @ApiOperation("根据联系人手机号修改")
    public ResultData UserUpdate(@RequestParam("phone")String phone, @RequestParam("companyName")String companyName){
        this.userService.updateUser(phone, companyName);
        return ResultData.success().message(String.valueOf(true));
    }
    @DeleteMapping("remove")
    @ApiOperation("根据联系人手机号删除")
    public ResultData UserDelete(@RequestParam("name")String name){
        this.userService.deleteUser(name);
        return ResultData.success().message(String.valueOf(true));
    }
}
