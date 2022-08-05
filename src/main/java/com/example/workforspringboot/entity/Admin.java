package com.example.workforspringboot.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //get、set
@ApiModel("用户类")
@AllArgsConstructor  //有参构造
@NoArgsConstructor  //无参构造
public class Admin {

    @JSONField(name="账户", ordinal = 2)
    @ApiModelProperty("账户")
    private String account;
    @JSONField(name="密码", ordinal = 1)
    @ApiModelProperty("密码")
    private String password;
}
