package com.je.cloud.busi.test.service;

import com.github.pagehelper.PageHelper;
import com.je.cloud.busi.test.mapper.TestMapper;
import com.je.cloud.disruptor.service.IHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service("testService")
public class TestService implements IHandleService {

    @Autowired
    private TestMapper testMapper;


    @Override
    public void exec(ConcurrentHashMap<String, Object> context) {
        System.out.println(context.get("username"));
    }

    public Object selectTest() {
        PageHelper.startPage(1, 1);
        return testMapper.selectTest();
    }
}
