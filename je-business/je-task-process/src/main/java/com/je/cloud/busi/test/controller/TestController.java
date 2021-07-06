package com.je.cloud.busi.test.controller;

import com.je.cloud.busi.test.service.TestService;
import com.je.cloud.disruptor.queue.DisruptorHandleQueue;
import com.je.cloud.disruptor.service.DisruptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class TestController {

//    @Autowired
//    private JwtService jwtService;

    @Autowired
    private DisruptorService disruptorService;

    @Autowired
    private RedisTemplate<String,Object> template;


    @Resource
    private TestService testService;

    @GetMapping("/")
    public Object index() {

        return null;
    }

    @GetMapping("/test")
    public Object test(HttpServletRequest request) {
        Object identityId = request.getAttribute("identityId");
        System.out.println(identityId);
        Object i = testService.selectTest();
        String token = (String) template.opsForValue().get("token");
        System.out.println(token);
        return i;
    }


    @GetMapping("/comm/login")
    public String test(HttpServletResponse response, String username, String password) {
        /**
         * 添加用户信息
         */
        String subject = "{\"username\":\"" + username + "\"}";
        String token = "";//jwtService.addTokenToCookie(response, subject);
        ConcurrentHashMap<String, Object> context = new ConcurrentHashMap<>();
        context.put("username", username);
        DisruptorHandleQueue queue = new DisruptorHandleQueue("233", "testService", context);
        disruptorService.addTask(queue);
        template.opsForValue().set("token",token);
        return token;
    }
}
