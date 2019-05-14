package com.mamba.houses.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * desc:
 * author:devzhong
 * Date:2018/6/21 18:56
 */
@ApiModel("经纪人列表")
public class OperateBrokerVO {

    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "性别-1女性,1男性,0其它")
    private String gender;
    @ApiModelProperty(value = "状态1可用,-1不可用")
    private String status;
    @ApiModelProperty(value = "电话号码")
    private String phone;
    @ApiModelProperty(value = "描述")
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
