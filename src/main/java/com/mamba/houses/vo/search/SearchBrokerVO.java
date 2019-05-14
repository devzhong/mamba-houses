package com.mamba.houses.vo.search;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("经纪人查询")
public class SearchBrokerVO {

    @ApiModelProperty(value = "经纪人姓名")
    private String name;
    @ApiModelProperty(value = "经纪人性别-1女性,1男性,0其它")
    private String gender;
    @ApiModelProperty(value = "经纪人状态1可用,-1不可用")
    private String status;
    @ApiModelProperty(value = "电话号码")
    private String phone;

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
}
