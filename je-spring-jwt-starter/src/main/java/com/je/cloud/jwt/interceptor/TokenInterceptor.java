package com.je.cloud.jwt.interceptor;

import com.je.cloud.base.domain.enums.ExceptionCodeEnum;
import com.je.cloud.base.exception.AuthorizationException;
import com.je.cloud.jwt.config.JwtConfig;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor extends HandlerInterceptorAdapter {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private JwtConfig jwtConfig;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
        /** 地址过滤 */
        String uri = request.getRequestURI();
        //log.info("TokenInterceptor" + ":" + uri);
        String[] Ignorepath = jwtConfig.getIgnorePath().split(",");

        String[] IgnoreIp = jwtConfig.getIgnoreIp().split(",");

        String ip = getIP(request);

        if (IgnoreIp.length >= 1) {
            for (String i : IgnoreIp) {
                if (i.equals(ip)) {
                    return true;
                }
            }
        }

        if (Ignorepath.length >= 1) {
            for (String path : Ignorepath) {
                if (uri.contains(path) || "/".equals(path)) {
                    return true;
                }
            }
        }

        /**
         *  Token 验证
         *  验证优先顺序：
         *      1.header
         *      2.parameter
         *      3.cookie
         */
        String token = request.getHeader(jwtConfig.getHeader());
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(jwtConfig.getHeader());
        }

        if (StringUtils.isEmpty(token)) {
            Cookie[] cs = request.getCookies();
            if (cs != null && cs.length >= 1) {
                for (Cookie cookie : cs) {
                    if (jwtConfig.getHeader().equals(cookie.getName())) {
                        token = cookie.getValue();
                    }
                }
            }
        }

        if (StringUtils.isEmpty(token)) {
            log.info("TokenInterceptor" + ": no token IP  --->  " + ip);
            log.info("TokenInterceptor" + ": no token uri  --->  " + uri);
            throw new AuthorizationException(jwtConfig.getHeader() + "不能为空");
        }

        Claims claims;
        try {
            claims = jwtConfig.getTokenClaim(token);
            if (claims == null || jwtConfig.isTokenExpired(claims.getExpiration())) {
                throw new AuthorizationException(ExceptionCodeEnum.Token_TIMEOUT.getCode(), jwtConfig.getHeader() + "失效，请重新登录。");
            }
        } catch (Exception e) {
            throw new AuthorizationException(jwtConfig.getHeader() + "失效，请重新登录。");
        }

        /** 设置 identityId 用户身份ID */
        request.setAttribute("identityId", claims.getSubject());
        return true;
    }

    public String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
