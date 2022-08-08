package com.example.workforspringboot;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.workforspringboot.entity.Admin;
import com.example.workforspringboot.mapper.AdminMapper;
import com.example.workforspringboot.service.AdminService;
import com.example.workforspringboot.service.ExcelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WorkForSpringbootApplicationTests {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ExcelService numberOfInstitutionsService;
    @Test
    void contextLoads() {
        Page<Admin> page = new Page<>(1, 2);
        Page<Admin> adminPage = adminMapper.selectPage(page, null);
        System.out.println(adminPage.getRecords());
        //System.out.println(adminPage);

        adminPage.getRecords().forEach(System.out::println);
    }
/*    @Test
    void ReadExicl(){
        boolean read = numberOfInstitutionsService.hutoolExcel2();
    }*/
}
