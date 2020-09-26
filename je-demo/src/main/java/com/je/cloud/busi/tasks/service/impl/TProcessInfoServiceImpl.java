package com.je.cloud.busi.tasks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.je.cloud.busi.tasks.domain.entity.TProcessInfo;
import com.je.cloud.busi.tasks.domain.entity.TProcessInfoExample;
import com.je.cloud.busi.tasks.mapper.TProcessInfoMapper;

import com.je.cloud.busi.tasks.service.TProcessInfoService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
*
* @Title:  TProcessInfoService实现类
* @Package com.je.cloud.busi.tasks.service.impl
* @Description:    ..
* @author: shengteli
* @date:   2020-09-25
* @version V1.0
*/
@Service
@Transactional
public  class TProcessInfoServiceImpl implements TProcessInfoService {

    @Autowired
    protected TProcessInfoMapper mapper;

    public void save(TProcessInfo model) {
        mapper.insertSelective(model);
    }

    public void save(List<TProcessInfo> models) {
        for (TProcessInfo model : models){
            mapper.insert(model);
        }
    }

    public void deleteById(String id) {
        mapper.deleteByPrimaryKey(id);
    }

    public void update(TProcessInfo model) {
        mapper.updateByPrimaryKeySelective(model);
    }

    public TProcessInfo findById(String id) {
        return mapper.selectByPrimaryKey(id);
    }


    public List<TProcessInfo> findByExample(TProcessInfoExample example) {
        return mapper.selectByExample(example);
    }

}
