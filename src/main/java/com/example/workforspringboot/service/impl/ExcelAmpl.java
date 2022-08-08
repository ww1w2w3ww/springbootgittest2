package com.example.workforspringboot.service.impl;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.workforspringboot.entity.Excel;
import com.example.workforspringboot.mapper.ExcelMapper;
import com.example.workforspringboot.service.ExcelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcelAmpl extends ServiceImpl<ExcelMapper, Excel> implements ExcelService {


    @Override
    public List<List<Object>> hutoolExcel2(String string) {
        ExcelReader reader = ExcelUtil.getReader(string);
        List<List<Object>> read = reader.read(1, reader.getRowCount());
        //System.out.println(read);
        for (List<Object> objects : read) {
// objects.get(0),读取某行第一列数据
// objects.get(1),读取某行第二列数据
            //objects.get(1);
        }
        reader.close();
        return read;

    }
}
