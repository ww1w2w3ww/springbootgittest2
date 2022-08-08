package com.example.workforspringboot.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workforspringboot.entity.Admin;
import com.example.workforspringboot.mapper.AdminMapper;
import com.example.workforspringboot.service.AdminService;
import com.example.workforspringboot.util.JWTUtils;
import com.example.workforspringboot.util.JsonListUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.plugin.table.HackLoopTableRenderPolicy;


import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class AdminImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    //
    @Override
    public List<Admin> listAdmin(String account) {
        QueryWrapper<Admin> wrapper=new QueryWrapper<>();
        wrapper.eq("account",account);
        List<Admin> admins=list(wrapper);
        return admins;
    }
    @Override
    public Page<Admin> pagelistAdmin(int current, int size) {
        Page<Admin> page = new Page<>(current, size);
        Page<Admin> adminPage = adminMapper.selectPage(page, null);
        //System.out.println(adminPage.getTotal());
        return adminPage;
    }

    @Override
    public boolean insertAdmin(Admin admin) {
        this.save(admin);
        return true;
    }

    @Override
    public boolean updateAdmin(String account, String password) {
        QueryWrapper<Admin> wrapper=new QueryWrapper<>();
        wrapper.eq("account",account);
        Admin admins = new Admin();
        admins.setPassword(password);
        this.update(admins,wrapper);
        return true;
    }

    @Override
    public boolean deleteAdmin(String account) {
        QueryWrapper<Admin> wrapper=new QueryWrapper<>();
        wrapper.eq("account",account);
        this.remove(wrapper);
        return true;
    }

    @Override
    public String login(Admin admin) {
        int count = count(new QueryWrapper<Admin>()
                        .eq("account",admin.getAccount())
                        .eq("password",admin.getPassword())
                //study_title为表中的列名，title为你要抓取到的数据名，.eq进行比较是否相同
                //count存储相同的个数
        );


        if (count>0) {

            return JWTUtils.getToken(admin);
        }
        return "登录失败！账号或者密码不对！";
    }

    @SneakyThrows
    @Override
    public boolean poi(Admin admin) {
        //1.在java中创建一个保存数据的map，key为对应word文本中的标签，值为要替换的数据，会将map中的对应的key替换为value
        Map<String, Object> datas = new HashMap<String, Object>();
        //2.给map添加要替换的数据
        //(1)简单的数据，替换的文本数据
        datas.put("var","数据内容");//可直接添加到map中
        //(2)动态的表格列表数据，要创建List集合，数据类型为map类型，map中的key为word中要遍历的列，值为要替换的内容
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();//创建map的List集合

        Map<String,Object> detailMap = new HashMap<String, Object>();//将word中标签名的例和对应数据保存到map

        detailMap.put("account", admin.getAccount());
        detailMap.put("password", admin.getPassword());
        list.add(detailMap);//将设置好的行保存到list集合中

        HackLoopTableRenderPolicy policy = new HackLoopTableRenderPolicy();//创建一个列表的规则
        Configure config = Configure.newBuilder().bind("admin", policy).build();//设置列表配置，如果有多个列表时需加.bind("list1", policy) 新列表配置即可
        datas.put("admin", list);		//将列表保存到渲染的map中
        //3.创建XWPFTemplate对象，并设置读取模板路径和要渲染的数据
        XWPFTemplate template = XWPFTemplate.compile("src/main/resources/static/Test2.docx",config).render(datas);
        //compile(模板路径,对应的配置)方法是设置模板路径和模板配置的，如果不设置配置时可不传config
        //render(datas)方法是用来渲染数据，将准备好的map数据方进去渲染
        //4.模板的输出，用FileOutputStream输出流（可以输出到指定文件位置，也可以用ajax直接返回给浏览器下载）
        FileOutputStream out = new FileOutputStream("D:/out/account.docx");//创建文件输出流并指定位置
        template.write(out);	//用XWPFTemplate对象的写write()方法将流写入

        return true;
    }

    @SneakyThrows
    @Override
    public boolean poiWord() {
        List<Admin> admins=list();
        //1.在java中创建一个保存数据的map，key为对应word文本中的标签，值为要替换的数据，会将map中的对应的key替换为value
        Map<String, Object> datas = new HashMap<String, Object>();
        //2.给map添加要替换的数据
        //(1)简单的数据，替换的文本数据
        datas.put("var","数据内容");//可直接添加到map中
        //(2)动态的表格列表数据，要创建List集合，数据类型为map类型，map中的key为word中要遍历的列，值为要替换的内容
        List<Map<String,Object>> list= JsonListUtil.EntityConvertMap(admins);

        HackLoopTableRenderPolicy policy = new HackLoopTableRenderPolicy();//创建一个列表的规则
        Configure config = Configure.newBuilder().bind("admin", policy).build();//设置列表配置，如果有多个列表时需加.bind("list1", policy) 新列表配置即可
        datas.put("admin", list);
        //将列表保存到渲染的map中
        //3.创建XWPFTemplate对象，并设置读取模板路径和要渲染的数据
        XWPFTemplate template = XWPFTemplate.compile("src/main/resources/static/Test2.docx",config).render(datas);
        //compile(模板路径,对应的配置)方法是设置模板路径和模板配置的，如果不设置配置时可不传config
        //render(datas)方法是用来渲染数据，将准备好的map数据方进去渲染
        //4.模板的输出，用FileOutputStream输出流（可以输出到指定文件位置，也可以用ajax直接返回给浏览器下载）
        FileOutputStream out = new FileOutputStream("D:/out/account2.docx");//创建文件输出流并指定位置
        template.write(out);	//用XWPFTemplate对象的写write()方法将流写入

        return true;
    }

    @Override
    public boolean hutoolExcel() {
        List<Admin> admins = list();
        List<Map<String,Object>> list= JsonListUtil.EntityConvertMap(admins);
        ArrayList<Map<String, Object>> rows = CollUtil.newArrayList(list);

        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("d:/writeMapTest.xlsx");
// 合并单元格后的标题行，使用默认标题样式
        writer.merge(list.size() - 1, "admin测试");
// 一次性写出内容，使用默认样式，强制输出标题
        writer.write(rows, true);
// 关闭writer，释放内存
        writer.close();
        return true;
    }}

