package com.mamba.houses.vo.list;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * desc:
 * author:devzhong
 * Date:2018/6/21 18:44
 */
@ApiModel("经纪人列表")
public class BrokerListVO {

    @ApiModelProperty(value = "唯一主键")
    private String uuid;
    @ApiModelProperty(value = "经纪人姓名")
    private String name;
    @ApiModelProperty(value = "性别")
    private String gender;
    @ApiModelProperty(value = "状态" )
    private String status;
    @ApiModelProperty(value = "电话号码")
    private String phone;
    @ApiModelProperty(value = "描述")
    private String desc;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
