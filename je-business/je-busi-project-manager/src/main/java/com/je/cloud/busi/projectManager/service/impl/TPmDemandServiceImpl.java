package com.je.cloud.busi.projectManager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.je.cloud.busi.projectManager.domain.entity.TPmDemand;
import com.je.cloud.busi.projectManager.domain.entity.TPmDemandExample;
import com.je.cloud.busi.projectManager.mapper.TPmDemandMapper;

import com.je.cloud.busi.projectManager.service.TPmDemandService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
*
* @Title:  TPmDemandService实现类
* @Package com.je.cloud.busi.projectManager.service.impl
* @Description:    ..
* @author: shengteli
* @date:   2021-01-20
* @version V1.0
*/
@Service
@Transactional
public  class TPmDemandServiceImpl implements TPmDemandService {

    @Autowired
    protected TPmDemandMapper mapper;

    public void save(TPmDemand model) {
        mapper.insertSelective(model);
    }

    public void save(List<TPmDemand> models) {
        for (TPmDemand model : models){
            mapper.insert(model);
        }
    }

    public void deleteById(String id) {
        mapper.deleteByPrimaryKey(id);
    }

    public void update(TPmDemand model) {
        mapper.updateByPrimaryKeySelective(model);
    }

    public TPmDemand findById(String id) {
        return mapper.selectByPrimaryKey(id);
    }


    public List<TPmDemand> findByExample(TPmDemandExample example) {
        return mapper.selectByExample(example);
    }

}
