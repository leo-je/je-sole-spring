package com.je.cloud.busi.tasks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.je.cloud.busi.tasks.domain.entity.TRuntimeProcess;
import com.je.cloud.busi.tasks.domain.entity.TRuntimeProcessExample;
import com.je.cloud.busi.tasks.mapper.TRuntimeProcessMapper;

import com.je.cloud.busi.tasks.service.TRuntimeProcessService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
*
* @Title:  TRuntimeProcessService实现类
* @Package com.je.cloud.busi.tasks.service.impl
* @Description:    ..
* @author: shengteli
* @date:   2020-09-26
* @version V1.0
*/
@Service
@Transactional
public  class TRuntimeProcessServiceImpl implements TRuntimeProcessService {

    @Autowired
    protected TRuntimeProcessMapper mapper;

    public void save(TRuntimeProcess model) {
        mapper.insertSelective(model);
    }

    public void save(List<TRuntimeProcess> models) {
        for (TRuntimeProcess model : models){
            mapper.insert(model);
        }
    }

    public void deleteById(String id) {
        mapper.deleteByPrimaryKey(id);
    }

    public void update(TRuntimeProcess model) {
        mapper.updateByPrimaryKeySelective(model);
    }

    public TRuntimeProcess findById(String id) {
        return mapper.selectByPrimaryKey(id);
    }


    public List<TRuntimeProcess> findByExample(TRuntimeProcessExample example) {
        return mapper.selectByExample(example);
    }

}
