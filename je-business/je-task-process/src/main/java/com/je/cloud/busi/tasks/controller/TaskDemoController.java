package com.je.cloud.busi.tasks.controller;


import com.je.cloud.busi.tasks.domain.entity.TProcessInfoExample;
import com.je.cloud.busi.tasks.domain.vo.TTaskVo;
import com.je.cloud.busi.tasks.service.TProcessInfoService;
import com.je.cloud.busi.tasks.service.TaskInsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/task")
public class TaskDemoController {

    @Resource
    private TProcessInfoService tProcessInfoService;

    @Resource
    private TaskInsService taskInsService;

    @GetMapping("/process/list")
    public Object processsList() {
        TProcessInfoExample exa = new TProcessInfoExample();
        exa.createCriteria().andIdIsNotNull();
        return tProcessInfoService.findByExample(exa);
    }

    @PostMapping("/task/add")
    public String addTask(@RequestBody TTaskVo vo) {
        taskInsService.add(vo);
        return vo.getId();
    }

    @GetMapping("/task/list")
    public Object taskList() {
        return taskInsService.taskList();

    }

    @GetMapping("/task/startTask")
    public String startTask(String id) {
        taskInsService.startTask(id);
        return id;
    }

    @GetMapping("/task/reStartTask")
    public String reStartTask(String id) {
        taskInsService.reStartTask(id);
        return id;
    }
}
