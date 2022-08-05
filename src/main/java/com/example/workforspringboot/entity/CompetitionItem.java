package com.example.workforspringboot.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //get、set
@ApiModel("比赛项目")
@AllArgsConstructor  //有参构造
@NoArgsConstructor  //无参构造
public class CompetitionItem {
    @ApiModelProperty("联系人手机号")
    private String phone;
    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty("提交时间")
    private java.util.Date submissionTime;

    @ApiModelProperty("比赛项目内容")
    private String content;
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("评审意见")
    private String opinion;



}
