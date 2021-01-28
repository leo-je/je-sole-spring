package com.je.cloud.busi.uc.controller;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

//@RestController
public class TestController {



    @GetMapping("/comm/login")
    public String test(HttpServletResponse response, String username, String password) {
        return null;
    }
}
