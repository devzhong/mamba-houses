package com.mamba.houses.dao;

import com.mamba.houses.po.BrokerPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrokerDao {
    List<BrokerPO> all();
    void create(BrokerPO po);
    void update(BrokerPO po);
    void delete(String Uuid);
    BrokerPO findBrokerByUuid(String Uuid);
}
