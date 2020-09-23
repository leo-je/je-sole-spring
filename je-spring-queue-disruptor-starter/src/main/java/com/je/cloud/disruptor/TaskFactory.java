package com.je.cloud.disruptor;

import com.je.cloud.disruptor.queue.DisruptorHandleQueue;
import com.lmax.disruptor.EventFactory;

public class TaskFactory implements EventFactory<DisruptorHandleQueue> {

    @Override
    public DisruptorHandleQueue newInstance() {
        // TODO Auto-generated method stub
        return new DisruptorHandleQueue();
    }

}
