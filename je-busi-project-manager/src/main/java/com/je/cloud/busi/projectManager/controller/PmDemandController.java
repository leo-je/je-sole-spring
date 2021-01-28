package com.je.cloud.busi.projectManager.controller;


import com.je.cloud.base.controller.BaseController;
import com.je.cloud.base.domain.vo.BasePage;
import com.je.cloud.base.domain.vo.ResponseData;
import com.je.cloud.busi.projectManager.domain.vo.DemandVo;
import com.je.cloud.busi.projectManager.service.impl.PmDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pm/busi/demand")
public class PmDemandController extends BaseController {

    @Autowired
    private PmDemandService demandService;

    @PostMapping("/add")
    public void add(@RequestBody DemandVo vo) {
        demandService.save(vo);
    }

    @PostMapping("/updateStatus")
    public void updateStatus(@RequestBody DemandVo vo) {
        demandService.updateStatus(vo);
    }

    @PostMapping("/list")
    public ResponseData<List<DemandVo>> list(@RequestBody BasePage vo) {
        return buildResponseData(() -> {
            List<DemandVo> list = demandService.list(vo);
            return list;
        }, "查询");
    }

    @GetMapping("/delete")
    public void del(String id) {
        demandService.delete(id);
    }

}
