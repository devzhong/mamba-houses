package com.mamba.houses.controller;

import com.mamba.houses.RestResponse;
import com.mamba.houses.exception.ServiceError;
import com.mamba.houses.service.BrokerService;
import com.mamba.houses.vo.OperateBrokerVO;
import com.mamba.houses.vo.list.BrokerListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * desc:
 * author:devzhong
 * Date:2018/4/19 13:26
 */
@Api(tags = "经纪人管理")
@RestController
@RequestMapping("/api/v1")
public class BrokerController {

    @Autowired
    private BrokerService brokerService;

    @ApiOperation("经纪人列表")
    @RequestMapping(value = "/brokers", method = RequestMethod.GET)
    public RestResponse<BrokerListVO> all(){
        return brokerService.all();
    }

    @ApiOperation("经纪人新增")
    @RequestMapping(value = "/brokers", method = RequestMethod.POST)
    public RestResponse create(@RequestBody OperateBrokerVO vo){
        if (StringUtils.isEmpty(vo.getName())){
            return RestResponse.error(ServiceError.BROKER_NAME_NULL);
        }
        return brokerService.create(vo);
    }

    @ApiOperation("经纪人更新")
    @RequestMapping(value = "/brokers/{uuid}", method = RequestMethod.PUT)
    public RestResponse update(@RequestBody OperateBrokerVO vo, @PathVariable("uuid") String uuid){
        return brokerService.update(vo, uuid);
    }

    @ApiOperation("经纪人删除")
    @RequestMapping(value = "/brokers/{uuid}", method = RequestMethod.DELETE)
    public RestResponse delete(@PathVariable("uuid") String uuid){
        if (StringUtils.isEmpty(uuid)){
            return RestResponse.error(ServiceError.BROKER_UUI_NULL);
        }
        return brokerService.delete(uuid);
    }
}
