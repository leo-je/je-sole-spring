package com.je.cloud.disruptor;

import com.je.cloud.disruptor.queue.DisruptorHandleQueue;
import com.lmax.disruptor.EventTranslatorVararg;
import com.lmax.disruptor.RingBuffer;
import org.springframework.beans.BeanUtils;

public class TaskProducerWithTranslator {
    //private static final Logger log = Logger.getLogger(TaskProducerWithTranslator.class);
    /**
     * TRANSLATOR
     */
    private final static EventTranslatorVararg<DisruptorHandleQueue> TRANSLATOR = new EventTranslatorVararg<DisruptorHandleQueue>() {
        @Override
        public void translateTo(DisruptorHandleQueue queue, long seq, Object... objs) {
            BeanUtils.copyProperties(objs[0], queue);
        }
    };

    private final RingBuffer<DisruptorHandleQueue> ringBuffer;

    public TaskProducerWithTranslator(RingBuffer<DisruptorHandleQueue> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(DisruptorHandleQueue sms) {
        this.ringBuffer.publishEvent(TRANSLATOR, sms);
    }

}
