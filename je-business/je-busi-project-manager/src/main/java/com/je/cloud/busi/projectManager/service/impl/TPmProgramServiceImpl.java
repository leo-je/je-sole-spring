package com.je.cloud.busi.projectManager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.je.cloud.busi.projectManager.domain.entity.TPmProgram;
import com.je.cloud.busi.projectManager.domain.entity.TPmProgramExample;
import com.je.cloud.busi.projectManager.mapper.TPmProgramMapper;

import com.je.cloud.busi.projectManager.service.TPmProgramService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
*
* @Title:  TPmProgramService实现类
* @Package com.je.cloud.busi.projectManager.service.impl
* @Description:    ..
* @author: shengteli
* @date:   2021-01-19
* @version V1.0
*/
@Service
@Transactional
public  class TPmProgramServiceImpl implements TPmProgramService {

    @Autowired
    protected TPmProgramMapper mapper;

    public void save(TPmProgram model) {
        mapper.insertSelective(model);
    }

    public void save(List<TPmProgram> models) {
        for (TPmProgram model : models){
            mapper.insert(model);
        }
    }

    public void deleteById(String id) {
        mapper.deleteByPrimaryKey(id);
    }

    public void update(TPmProgram model) {
        mapper.updateByPrimaryKeySelective(model);
    }

    public TPmProgram findById(String id) {
        return mapper.selectByPrimaryKey(id);
    }


    public List<TPmProgram> findByExample(TPmProgramExample example) {
        return mapper.selectByExample(example);
    }

}
