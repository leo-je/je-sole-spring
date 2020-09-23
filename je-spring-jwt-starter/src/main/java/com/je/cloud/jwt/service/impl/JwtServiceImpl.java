package com.je.cloud.jwt.service.impl;

import com.je.cloud.jwt.config.JwtConfig;
import com.je.cloud.jwt.service.JwtService;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

//@Service
public class JwtServiceImpl implements JwtService {

    @Resource
    private JwtConfig jwtConfig;

    @Override
    public String addTokenToCookie(HttpServletResponse response, String subject) {
        String token = jwtConfig.createToken(subject);
        Cookie cookie = new Cookie(jwtConfig.getHeader(), token);
        cookie.setPath("/");
        response.addCookie(cookie);
        return token;
    }

    @Override
    public String createToken(String subject) {
        String token = jwtConfig.createToken(subject);
        return token;
    }
}
