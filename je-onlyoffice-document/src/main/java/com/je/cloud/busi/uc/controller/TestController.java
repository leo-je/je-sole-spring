package com.je.cloud.busi.uc.controller;

import com.je.cloud.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ConcurrentHashMap;

//@RestController
public class TestController {

    @Autowired
    private JwtService jwtService;

    @GetMapping("/comm/login")
    public String test(HttpServletResponse response, String username, String password) {
        /**
         * 添加用户信息
         */
        String subject = "{\"username\":\"" + username + "\"}";
        String token = jwtService.addTokenToCookie(response, subject);
        ConcurrentHashMap<String, Object> context = new ConcurrentHashMap<>();
        context.put("username", username);
        return token;
    }
}
