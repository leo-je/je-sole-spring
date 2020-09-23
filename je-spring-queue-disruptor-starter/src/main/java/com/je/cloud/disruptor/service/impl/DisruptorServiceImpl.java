package com.je.cloud.disruptor.service.impl;

import com.je.cloud.disruptor.component.DisruptorComponent;
import com.je.cloud.disruptor.queue.DisruptorHandleQueue;
import com.je.cloud.disruptor.service.DisruptorService;

import javax.annotation.Resource;

public class DisruptorServiceImpl implements DisruptorService {

    @Resource
    DisruptorComponent disruptorComponent;

    @Override
    public void addTask(DisruptorHandleQueue queue) {
        disruptorComponent.addTask(queue);
    }
}
