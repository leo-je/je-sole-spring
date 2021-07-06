package com.je.cloud.busi.projectManager.service.impl;

import com.github.pagehelper.PageHelper;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.je.cloud.base.domain.vo.BasePage;
import com.je.cloud.base.utils.UUIDUtils;
import com.je.cloud.busi.projectManager.domain.entity.TPmDemand;
import com.je.cloud.busi.projectManager.domain.vo.DemandVo;
import com.je.cloud.busi.projectManager.mapper.PmVoMapper;
import com.je.cloud.busi.projectManager.mapper.TPmDemandMapper;
import com.je.cloud.busi.projectManager.service.TPmDemandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("demandService")
public class PmDemandService {

    @Resource
    private TPmDemandService tPmDemandService;

    @Resource
    private PmVoMapper pmVoMapper;

    @Resource
    private TPmDemandMapper tPmDemandMapper;

    Type psType = new TypeToken<List<Map<String, String>>>() {
    }.getType();

    public void save(DemandVo vo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        List<Map<String, String>> pl = vo.getProgramList();
        if (pl != null && pl.size() > 0) {
            String ps = new Gson().toJson(vo.getProgramList(), psType);
            vo.setPrograms(ps);
        }
        String updateLog = "";
        if (StringUtils.isNotBlank(vo.getId())) {
            TPmDemand e = tPmDemandService.findById(vo.getId());
            if (!StringUtils.equals(e.getName(), vo.getName())) {
                updateLog += "   名称变更:" + e.getName() + "--->" + vo.getName()+"||";
            }
            if (!StringUtils.equals(e.getProjectName(), vo.getProjectName())) {
                updateLog += "   项目变更:" + e.getProjectName() + "--->" + vo.getProjectName()+"||";
            }

            if (vo.getScheduledFinishTime() != null && !StringUtils.equals(sdf.format(e.getScheduledFinishTime()),sdf.format(vo.getScheduledFinishTime()))) {
                updateLog += "   计划完成时间变更:" + sdf.format(e.getScheduledFinishTime()) + "--->" + sdf.format(vo.getScheduledFinishTime())+"||";
            }

            if (vo.getScheduledOnLineTime() != null && !StringUtils.equals(sdf.format(e.getScheduledOnLineTime()),sdf.format(vo.getScheduledOnLineTime()))) {
                updateLog += "   计划上线时间变更:" + sdf.format(e.getScheduledOnLineTime()) + "--->" + sdf.format(vo.getScheduledOnLineTime())+"||";
            }

            if (!StringUtils.equals(e.getVersion(),vo.getVersion())) {
                updateLog += "   挂载版本:" + e.getVersion() + "--->" + vo.getVersion()+"||";
            }

            if (StringUtils.isNotBlank(updateLog)) {
                String log = e.getLog();
                log += sdf.format(now) + " 更新:"+"||";
                log += updateLog + "\n";
                vo.setLog(log);
            }else {
                vo.setLog(null);
            }
            tPmDemandService.update(vo);
        } else {
            vo.setStatus("0");
            vo.setId(UUIDUtils.getId());
            updateLog = sdf.format(now)+"||   新建"+"||";
            vo.setLog(updateLog);
            if (vo.getScheduledOnLineTime() == null){
                vo.setScheduledOnLineTime(now);
            }
            if (vo.getScheduledFinishTime() == null){
                vo.setScheduledFinishTime(now);
            }
            tPmDemandService.save(vo);
        }
    }

    public List<DemandVo> list(BasePage vo) {
        PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
        List<DemandVo> list = pmVoMapper.getDemandList();
        if (list != null && list.size() > 0) {
            list.forEach(e -> {
                if (StringUtils.isNotBlank(e.getPrograms())) {
                    List<Map<String, String>> ps = new Gson().fromJson(e.getPrograms(), psType);
                    e.setProgramList(ps);
                }
            });
        }
        return list;
    }

    public void delete(String id) {
        tPmDemandService.deleteById(id);
    }

    public void updateStatus(DemandVo vo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        List<Map<String, String>> pl = vo.getProgramList();
        if (pl != null && pl.size() > 0) {
            String ps = new Gson().toJson(vo.getProgramList(), psType);
            vo.setPrograms(ps);
        }
        String updateLog = "";
        if (StringUtils.isNotBlank(vo.getId())) {
            TPmDemand e = tPmDemandService.findById(vo.getId());
            if (!StringUtils.equals(e.getStatus(), vo.getStatus())) {
                updateLog += "   状态变更:" + getStatus(e.getStatus()) + "--->" + getStatus(vo.getStatus())+"||";
            }

            if (StringUtils.isNotBlank(updateLog)) {
                String log = e.getLog();
                log += sdf.format(now) + " 更新:"+"||";
                log += updateLog + "\n";
                vo.setLog(log);
            }else {
                vo.setLog(null);
            }
            tPmDemandService.update(vo);
        }
    }


    public String getStatus(String status){
        switch (status){
            case "0":
                return "未开始";
            case "1":
                return "进行中";
            case "2":
                return "完成开发";
            case "3":
                return "已上线";
            case "4":
                return "中止开发";
            case "5":
                return "废弃";
            default:
                return "未定义";

        }
    }
}
