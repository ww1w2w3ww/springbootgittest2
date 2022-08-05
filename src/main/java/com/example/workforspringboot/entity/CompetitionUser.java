package com.example.workforspringboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //get、set
@ApiModel("公司相关")
@AllArgsConstructor  //有参构造
@NoArgsConstructor  //无参构造
public class CompetitionUser {
    @ApiModelProperty("联系人手机号")
    private String phone;
    @ApiModelProperty("联系人姓名")
    private String name;
    @ApiModelProperty("企业名称")
    private String companyName;
    @ApiModelProperty("密码")
    private String password;
}
