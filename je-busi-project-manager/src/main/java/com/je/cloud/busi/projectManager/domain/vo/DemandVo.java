package com.je.cloud.busi.projectManager.domain.vo;

import com.je.cloud.busi.projectManager.domain.entity.TPmDemand;

import java.util.List;
import java.util.Map;

public class DemandVo extends TPmDemand {

    private List<Map<String, String>> programList;

    public List<Map<String, String>> getProgramList() {
        return programList;
    }

    public void setProgramList(List<Map<String, String>> programList) {
        this.programList = programList;
    }
}
