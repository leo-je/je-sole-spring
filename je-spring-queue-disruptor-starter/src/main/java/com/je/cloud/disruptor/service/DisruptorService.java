package com.je.cloud.disruptor.service;

import com.je.cloud.disruptor.queue.DisruptorHandleQueue;

public interface DisruptorService {

    void addTask(DisruptorHandleQueue queue);
}
