package com.je.cloud.busi.projectManager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.je.cloud.busi.projectManager.domain.entity.TPmProject;
import com.je.cloud.busi.projectManager.domain.entity.TPmProjectExample;
import com.je.cloud.busi.projectManager.mapper.TPmProjectMapper;

import com.je.cloud.busi.projectManager.service.TPmProjectService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
*
* @Title:  TPmProjectService实现类
* @Package com.je.cloud.busi.projectManager.service.impl
* @Description:    ..
* @author: shengteli
* @date:   2021-01-18
* @version V1.0
*/
@Service
@Transactional
public  class TPmProjectServiceImpl implements TPmProjectService {

    @Autowired
    protected TPmProjectMapper mapper;

    public void save(TPmProject model) {
        mapper.insertSelective(model);
    }

    public void save(List<TPmProject> models) {
        for (TPmProject model : models){
            mapper.insert(model);
        }
    }

    public void deleteById(String id) {
        mapper.deleteByPrimaryKey(id);
    }

    public void update(TPmProject model) {
        mapper.updateByPrimaryKeySelective(model);
    }

    public TPmProject findById(String id) {
        return mapper.selectByPrimaryKey(id);
    }


    public List<TPmProject> findByExample(TPmProjectExample example) {
        return mapper.selectByExample(example);
    }

}
