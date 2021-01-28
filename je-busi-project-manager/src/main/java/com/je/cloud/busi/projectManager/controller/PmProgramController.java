package com.je.cloud.busi.projectManager.controller;


import com.je.cloud.busi.projectManager.domain.entity.TPmProgram;
import com.je.cloud.busi.projectManager.service.impl.PmProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pm/busi/program")
public class PmProgramController {

    @Autowired
    private PmProgramService programService;

    @PostMapping("/add")
    public void add(@RequestBody TPmProgram vo) {
        programService.save(vo);
    }

    @PostMapping("/list")
    public Object list() {
        List<TPmProgram> list = programService.list();
        return list;
    }

    @GetMapping("/delete")
    public void list(String id) {
        programService.delete(id);
    }
}
