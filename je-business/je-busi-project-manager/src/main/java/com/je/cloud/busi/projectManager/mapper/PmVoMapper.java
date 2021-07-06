package com.je.cloud.busi.projectManager.mapper;

import com.je.cloud.busi.projectManager.domain.vo.DemandVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PmVoMapper {

    @Select("<script>" +
            "select * from t_pm_demand " +
            "order by sort desc " +
            "</script>")
    List<DemandVo> getDemandList();
}
