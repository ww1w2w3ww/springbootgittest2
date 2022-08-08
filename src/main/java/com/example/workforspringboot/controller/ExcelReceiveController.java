package com.example.workforspringboot.controller;


import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.example.workforspringboot.service.impl.ExcelAmpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(value = "Excel",method = {RequestMethod.GET,RequestMethod.POST})
@Api(value = "Excel上传下载测试", tags = {"Excel上传下载测试"})

public class ExcelReceiveController {
    @Autowired
    private ExcelAmpl excelReceive;

    @SneakyThrows
    @ApiOperation("测试poi-tlw")
    @GetMapping("receive")

/*    public List<List<Object>> hutoolReceive(@RequestParam("name")String name){
        List<List<Object>> read = excelReceive.hutoolExcel2("static/"+name+".xlsx");
        return read;
    }*/
    public List<List<Object>> hutoolReceive(@RequestParam("name")String name){
        ExcelReader reader = ExcelUtil.getReader("static/"+name+".xlsx");
        List<List<Object>> read = reader.read(1, reader.getRowCount());
        reader.close();
        return read;
    }

/*    @SneakyThrows
    @ApiOperation("测试poi-tlw2")
    @GetMapping("hutoolw2")
    @Autowired
    public List<List<Object>> hutoolExcelw2(){
        List<List<Object>> read = excelReceiveconfig.hutoolExcel2("static/1.1国家级和省级研发机构数---核对模板(1).xlsx");
        return read;
    }*/

}
