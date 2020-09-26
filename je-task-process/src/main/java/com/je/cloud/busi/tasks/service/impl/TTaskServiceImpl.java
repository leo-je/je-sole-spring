package com.je.cloud.busi.tasks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.je.cloud.busi.tasks.domain.entity.TTask;
import com.je.cloud.busi.tasks.domain.entity.TTaskExample;
import com.je.cloud.busi.tasks.mapper.TTaskMapper;

import com.je.cloud.busi.tasks.service.TTaskService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
*
* @Title:  TTaskService实现类
* @Package com.je.cloud.busi.tasks.service.impl
* @Description:    ..
* @author: shengteli
* @date:   2020-09-26
* @version V1.0
*/
@Service
@Transactional
public  class TTaskServiceImpl implements TTaskService {

    @Autowired
    protected TTaskMapper mapper;

    public void save(TTask model) {
        mapper.insertSelective(model);
    }

    public void save(List<TTask> models) {
        for (TTask model : models){
            mapper.insert(model);
        }
    }

    public void deleteById(String id) {
        mapper.deleteByPrimaryKey(id);
    }

    public void update(TTask model) {
        mapper.updateByPrimaryKeySelective(model);
    }

    public TTask findById(String id) {
        return mapper.selectByPrimaryKey(id);
    }


    public List<TTask> findByExample(TTaskExample example) {
        return mapper.selectByExample(example);
    }

}
