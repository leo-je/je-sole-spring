package com.je.cloud.disruptor.component;


import com.je.cloud.disruptor.EventExceptionHandler;
import com.je.cloud.disruptor.TaskEventConsumer;
import com.je.cloud.disruptor.TaskFactory;
import com.je.cloud.disruptor.TaskProducerWithTranslator;
import com.je.cloud.disruptor.config.DisruptorConfig;
import com.je.cloud.disruptor.queue.DisruptorHandleQueue;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.WorkerPool;
import com.lmax.disruptor.dsl.ProducerType;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;


public class DisruptorComponent implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger logger = LoggerFactory.getLogger(DisruptorComponent.class);

    @Resource
    private DisruptorConfig disruptorConfig;

    /**
     * 线程集
     */
    ExecutorService executor = null;
    private RingBuffer<DisruptorHandleQueue> ringBuffer = null;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            producerWithTranslator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 环形队列入队
     *
     * @param sms
     */
    public void addTask(DisruptorHandleQueue queue) {
        TaskProducerWithTranslator producer = new TaskProducerWithTranslator(ringBuffer);
        producer.onData(queue);
    }


    //启动服务,初始化队列处理线程集
    private void producerWithTranslator() {
        logger.info("-------------> DisruptorComponent: Disruptor Handle service starting");
        TaskFactory factory = new TaskFactory();
        // 2^N
        int ringBufferSize = disruptorConfig.getRingBufferSize();
        int poolSize = disruptorConfig.getRingBufferSize();

        executor = new ScheduledThreadPoolExecutor(poolSize,
                new BasicThreadFactory.Builder().namingPattern("Disruptor Worker-schedule-pool-%d").daemon(true).build());

        ringBuffer = RingBuffer.create(ProducerType.MULTI, factory, ringBufferSize, new BlockingWaitStrategy());
        SequenceBarrier barriers = ringBuffer.newBarrier();
        TaskEventConsumer[] consumers = new TaskEventConsumer[3];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new TaskEventConsumer();
        }
        WorkerPool<DisruptorHandleQueue> workerPool = new WorkerPool<>(ringBuffer, barriers, new EventExceptionHandler(), consumers);
        ringBuffer.addGatingSequences(workerPool.getWorkerSequences());
        workerPool.start(executor);
        logger.info("-------------> DisruptorComponent: Disruptor Handle service end");
    }
}
