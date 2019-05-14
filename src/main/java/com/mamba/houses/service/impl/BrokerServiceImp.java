package com.mamba.houses.service.impl;

import com.mamba.houses.RestResponse;
import com.mamba.houses.dao.BrokerDao;
import com.mamba.houses.exception.ServiceError;
import com.mamba.houses.po.BrokerPO;
import com.mamba.houses.service.BrokerService;
import com.mamba.houses.util.UuidUtil;
import com.mamba.houses.vo.OperateBrokerVO;
import com.mamba.houses.vo.list.BrokerListVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * desc:
 * author:devzhong
 * Date:2018/5/14 15:18
 */
@Service
public class BrokerServiceImp implements BrokerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BrokerService.class);

    @Autowired
    private BrokerDao brokerDao;

    @Override
    public RestResponse<BrokerListVO> all() {
        try {
            return RestResponse.success(buildBrokerList(brokerDao.all()));
        }catch (Exception e){
            LOGGER.error("OrganService all error {}",e);
            return RestResponse.error(ServiceError.UM_SERVICE_ERROR);
        }
    }

    @Override
    public RestResponse create(OperateBrokerVO vo) {
        try {
            BrokerPO po = buildBroker(new BrokerPO(), vo);
            po.setUuid(UuidUtil.generate());
            brokerDao.create(po);
            return RestResponse.success();
        } catch (Exception e) {
            LOGGER.error("BrokerService create error {}", e);
            return RestResponse.error(ServiceError.UM_SERVICE_ERROR);
        }
    }

    //经纪人更新
    @Override
    public RestResponse update(OperateBrokerVO vo, String uuid) {
        try{
            BrokerPO oldBroker = brokerDao.findBrokerByUuid(uuid);
            if (oldBroker == null){
                return RestResponse.error(ServiceError.BROKER_NOT_FOUND);
            }
            brokerDao.update(buildBroker(oldBroker, vo));
            return RestResponse.success();
        }catch (Exception e){
            LOGGER.error("BrokerService update error {}", e);
            return RestResponse.error(ServiceError.UM_SERVICE_ERROR);
        }
    }

    //经纪人删除
    @Override
    public RestResponse delete(String uuid) {
        try {
            if (brokerDao.findBrokerByUuid(uuid) == null) {
                return RestResponse.error(ServiceError.BROKER_NOT_FOUND);
            }
            brokerDao.delete(uuid);
            return RestResponse.success();
        } catch (Exception e) {
            LOGGER.error("BrokerService delete error {}", e);
            return RestResponse.error(ServiceError.UM_SERVICE_ERROR);
        }
    }


    //构建经纪人数据结构
    private BrokerPO buildBroker(BrokerPO po, OperateBrokerVO vo) {
        po.setStatus(vo.getStatus());
        po.setDesc(vo.getDesc());
        po.setGender(vo.getGender());
        po.setName(vo.getName());
        po.setPhone(vo.getPhone());
        po.setCreateTime(new Date());
        po.setUpdateTime(new Date());
        return po;
    }

    //构建经纪人列表数据结构
    private List<BrokerListVO> buildBrokerList(List<BrokerPO> pos){
        List<BrokerListVO> vos = new ArrayList<>();
        for (BrokerPO po: pos){
            BrokerListVO vo = new BrokerListVO();
            vo.setName(po.getName());
            vo.setUuid(po.getUuid());
            vo.setGender(po.getGender());
            vo.setDesc(po.getDesc());
            vo.setStatus(po.getStatus());
            vo.setPhone(po.getPhone());
            vo.setCreateTime(po.getCreateTime());
            vo.setUpdateTime(po.getUpdateTime());
            vos.add(vo);
        }
        return vos;
    }
}
