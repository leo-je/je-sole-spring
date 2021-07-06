package com.je.cloud.busi.uc.controller;

import com.je.cloud.base.exception.ApplicationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController {



    @GetMapping("/comm/login")
    public String test(HttpServletResponse response, String username, String password) {
        if (true){
            throw new ApplicationException("测试");
        }
        return "sss";
    }
}
