package com.je.cloud.disruptor.service;

import java.util.concurrent.ConcurrentHashMap;

public interface IHandleService {
    void exec(ConcurrentHashMap<String, Object> context);
}
