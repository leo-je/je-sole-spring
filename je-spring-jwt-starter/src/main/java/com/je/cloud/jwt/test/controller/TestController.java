package com.je.cloud.jwt.test.controller;


import com.je.cloud.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@RestController
public class TestController {

    @Autowired
    private JwtService jwtService;

    @GetMapping("/test")
    public Object test(HttpServletRequest request) {
        Object identityId = request.getAttribute("identityId");
        return identityId;
    }


    @GetMapping("/comm/login")
    public String test(HttpServletResponse response, String username, String password) {
        /**
         * 添加用户信息
         */
        String subject = "{\"username\":\"" + username + "\"}";
        String token = jwtService.addTokenToCookie(response, subject);
        return token;
    }
}
