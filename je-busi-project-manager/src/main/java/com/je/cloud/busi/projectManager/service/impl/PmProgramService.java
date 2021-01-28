package com.je.cloud.busi.projectManager.service.impl;

import com.je.cloud.base.utils.UUIDUtils;
import com.je.cloud.busi.projectManager.domain.entity.TPmProgram;
import com.je.cloud.busi.projectManager.domain.entity.TPmProgramExample;
import com.je.cloud.busi.projectManager.mapper.TPmProgramMapper;
import com.je.cloud.busi.projectManager.service.TPmProgramService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PmProgramService {

    @Resource
    private TPmProgramService tPmProgramService;

    @Resource
    private TPmProgramMapper tPmProgramMapper;

    public void save(TPmProgram program) {
        if (StringUtils.isNotBlank(program.getId())) {
            tPmProgramService.update(program);
        } else {
            program.setId(UUIDUtils.getId());
            TPmProgramExample exa = new TPmProgramExample();
            long count = tPmProgramMapper.countByExample(exa);
            program.setSort(Integer.valueOf(count + ""));
            tPmProgramService.save(program);
        }
    }

    public List<TPmProgram> list() {
        TPmProgramExample exa = new TPmProgramExample();
        return tPmProgramService.findByExample(exa);
    }

    public void delete(String id) {
        tPmProgramService.deleteById(id);
    }
}
