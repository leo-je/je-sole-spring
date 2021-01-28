package com.je.cloud.busi.projectManager.controller;


import com.je.cloud.busi.projectManager.domain.entity.TPmProject;
import com.je.cloud.busi.projectManager.service.impl.PmProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pm/busi/project")
public class PmProjectController {


    @Autowired
    private PmProjectService projectService;

    @PostMapping("/add")
    public void add(@RequestBody TPmProject project) {
        projectService.save(project);
    }

    @PostMapping("/list")
    public Object list() {
        List<TPmProject> list = projectService.list();
        return list;
    }

    @GetMapping("/delete")
    public void list(String id) {
         projectService.delete(id);
    }

}
