package com.mamba.houses.service;

import com.mamba.houses.RestResponse;
import com.mamba.houses.vo.OperateBrokerVO;
import com.mamba.houses.vo.list.BrokerListVO;

public interface BrokerService {

    public RestResponse<BrokerListVO> all();
    public RestResponse create(OperateBrokerVO vo);
    public RestResponse update(OperateBrokerVO vo, String uuid);
    public RestResponse delete(String uuid);



}
