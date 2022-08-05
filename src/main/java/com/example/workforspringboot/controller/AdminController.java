package com.example.workforspringboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.example.workforspringboot.result.ResultData;
import com.example.workforspringboot.entity.Admin;

import com.example.workforspringboot.mapper.AdminMapper;
import com.example.workforspringboot.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import java.io.IOException;


@RestController
@ResponseBody
@RequestMapping(value = "admin",method = {RequestMethod.GET,RequestMethod.POST})
@Api(value = "用户接口", tags = {"用户接口"})

public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminMapper adminMapper;
//
    @GetMapping
    @ApiOperation("全查询")
    public List<Admin> AdminSelect2(){
    List<Admin> admins=adminService.list();
    return admins;
}
    @GetMapping(value = "select")
    @ApiOperation("根据用户名查找")
    public List<Admin> AdminSelect(@RequestParam("account")String account){
        List<Admin> admins = adminService.listAdmin(account);

        return admins;
    }
    @ApiOperation("分页查找")
    @GetMapping(value = "page")
    public List<Admin> AdminPageSelect(@RequestParam("current")int current, @RequestParam("size")int size){

        //Page<Admin> adminPage = adminMapper.selectPage(page, null);
        //System.out.println(adminPage.getTotal());
        //int i=1/0;
        Page<Admin> adminPage=adminService.pagelistAdmin(current,size);
        return adminPage.getRecords();
    }
    @ApiOperation("插入")
    @PostMapping(value = "insert")
    public ResultData AdminInsert(Admin admin){
        this.adminService.insertAdmin(admin);
        this.adminService.poi(admin);
        return ResultData.success().message(String.valueOf(true));
    }
    @ApiOperation("根据账户名称进行修改")
    @PostMapping(value = "update")
    public ResultData AdminUpdate(@RequestParam("account")String account, @RequestParam("password")String password){
        this.adminService.updateAdmin(account,password);
        return ResultData.success().message(String.valueOf(true));
    }
    @ApiOperation("根据账户名称查询")
    @DeleteMapping(value = "delete")
    public ResultData AdminDelete(@RequestParam("account")String account){
        this.adminService.deleteAdmin(account);
        return ResultData.success().message(String.valueOf(true));
    }

    @ApiOperation("登录")
    @GetMapping("login")
    public String login(Admin admin) {
        String login= adminService.login(admin);
/*        int count = adminService.count(new QueryWrapper<Admin>()
                        .eq("account",admin.getAccount()).eq("password",admin.getPassword())
                //study_title为表中的列名，title为你要抓取到的数据名，.eq进行比较是否相同
                //count存储相同的个数
        );


        if (count>0) {

            return JWTUtils.getToken(admin);
        }*/
        return login;
    }

    @ApiOperation("测试登录结果")
    @GetMapping("test")
    public String test()  {
        return "访问test - API";
    }

    @ApiOperation("测试poi-tl")
    @GetMapping("poi-tl")
    public boolean test2() throws IOException {
        this.adminService.poiWord();
        return true;
    }
   /* @SneakyThrows
    @ApiOperation("测试poi-tl")
    @GetMapping("hutool")
    public boolean hutool(HttpServletResponse response) throws IOException, ClassNotFoundException{
        ExcelWriter writer = ExcelUtil.getWriter();
        List<Admin> admins = adminService.list();
        List<Map<String,Object>> list= JsonListUtil.EntityConvertMap(admins);
        int columns = Class.forName("com/example/workforspringboot/entity/Admin.java").getDeclaredFields().length;
        // Title
        writer.merge(columns - 1, "员工信息");
        // Header
        writer.addHeaderAlias("account", "ID");
        writer.addHeaderAlias("password", "密码");
        // Body
        writer.setColumnWidth(0, 30);
        writer.setColumnWidth(1, 30);

        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode("员工信息表-"+".xls", "utf-8"));

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(out);
        return true;
    }*/
    @SneakyThrows
    @ApiOperation("测试poi-tl")
    @GetMapping("hutool")
    public boolean hutoolExcel(){
        this.adminService.hutoolExcel();
        return true;
    }
}
