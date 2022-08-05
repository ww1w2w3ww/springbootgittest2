package com.example.workforspringboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.workforspringboot.result.ResultData;
import com.example.workforspringboot.entity.CompetitionItem;
import com.example.workforspringboot.service.CompetitionItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "item",method = {RequestMethod.GET,RequestMethod.POST})
@Api(value = "内容接口", tags = {"内容接口"})
public class CompetitionItemController {

    @Autowired
    private CompetitionItemService itemService;
    @GetMapping(value = "select")
    @ApiOperation("根据联系人手机号查找")
    public List<CompetitionItem> ItemSelect(@RequestParam("content")String content){
        List<CompetitionItem> competitionItems=itemService.listItem(content);
        return competitionItems;
    }
    @GetMapping(value = "page")
    @ApiOperation("分页查找")
    public List<CompetitionItem> ItemPageSelect(@RequestParam("current")int current, @RequestParam("size")int size){

        //Page<Admin> adminPage = adminMapper.selectPage(page, null);
        //System.out.println(adminPage.getTotal());
        //int i=1/0;
        Page<CompetitionItem> itemPage=itemService.pagelistItem(current,size);
        return itemPage.getRecords();
    }
    @ApiOperation("插入数据")
    @PostMapping (value="insert")
    public ResultData ItemInert(CompetitionItem competitionItem){
        this.itemService.insertItem(competitionItem);
        return ResultData.success().message(String.valueOf(true));
    }
    @ApiOperation("根据联系人手机号修改")
    @PostMapping(value = "update")
    public ResultData ItemUpdate(@RequestParam("phone")String phone, @RequestParam("opinion")String opinion,
                                 @RequestParam("status")String status){
        this.itemService.updateItem(phone,opinion,status);
        return ResultData.success().message(String.valueOf(true));
    }
    @ApiOperation("根据联系人手机号删除")
    @DeleteMapping("delete")
    public ResultData ItemDelete(@RequestParam("content")String content){

        this.itemService.deleteItem(content);
        return ResultData.success().message(String.valueOf(true));
    }
}
