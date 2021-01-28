package com.je.cloud.busi.projectManager.service.impl;

import com.je.cloud.base.utils.UUIDUtils;
import com.je.cloud.busi.projectManager.domain.entity.TPmProject;
import com.je.cloud.busi.projectManager.domain.entity.TPmProjectExample;
import com.je.cloud.busi.projectManager.service.TPmProjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("projectService")
@Transactional
public class PmProjectService {

    @Autowired
    private TPmProjectService tPmProjectService;

    public void save(TPmProject project) {
        if (StringUtils.isNotBlank(project.getId())) {
            tPmProjectService.update(project);
        } else {
            project.setId(UUIDUtils.getId());
            tPmProjectService.save(project);
        }

    }

    public List<TPmProject> list() {
        TPmProjectExample exa = new TPmProjectExample();
        return tPmProjectService.findByExample(exa);
    }

    public void delete(String id) {
        tPmProjectService.deleteById(id);
    }
}
