package com.je.cloud.disruptor;

import com.je.cloud.disruptor.queue.DisruptorHandleQueue;
import com.lmax.disruptor.ExceptionHandler;

public class EventExceptionHandler implements ExceptionHandler<DisruptorHandleQueue> {

    @Override
    public void handleEventException(Throwable ex, long sequence, DisruptorHandleQueue event) {
        System.out.println("handleEventException：" + ex);
    }

    @Override
    public void handleOnShutdownException(Throwable ex) {
        System.out.println("handleEventException：" + ex);
    }

    @Override
    public void handleOnStartException(Throwable ex) {
        System.out.println("handleOnStartException：" + ex);
    }

}
