package com.je.cloud.busi.tasks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.je.cloud.busi.tasks.domain.entity.TaskHistory;
import com.je.cloud.busi.tasks.domain.entity.TaskHistoryExample;
import com.je.cloud.busi.tasks.mapper.TaskHistoryMapper;

import com.je.cloud.busi.tasks.service.TaskHistoryService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
*
* @Title:  TaskHistoryService实现类
* @Package com.je.cloud.busi.tasks.service.impl
* @Description:    ..
* @author: shengteli
* @date:   2020-09-26
* @version V1.0
*/
@Service
@Transactional
public  class TaskHistoryServiceImpl implements TaskHistoryService {

    @Autowired
    protected TaskHistoryMapper mapper;

    public void save(TaskHistory model) {
        mapper.insertSelective(model);
    }

    public void save(List<TaskHistory> models) {
        for (TaskHistory model : models){
            mapper.insert(model);
        }
    }

    public void deleteById(String id) {
        mapper.deleteByPrimaryKey(id);
    }

    public void update(TaskHistory model) {
        mapper.updateByPrimaryKeySelective(model);
    }

    public TaskHistory findById(String id) {
        return mapper.selectByPrimaryKey(id);
    }


    public List<TaskHistory> findByExample(TaskHistoryExample example) {
        return mapper.selectByExample(example);
    }

}
