package com.je.cloud.jwt.service;

import javax.servlet.http.HttpServletResponse;

public interface JwtService {
    String addTokenToCookie(HttpServletResponse response, String subject);

    String createToken(String subject);

}
