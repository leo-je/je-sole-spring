package com.je.cloud.disruptor;

import com.je.cloud.disruptor.queue.DisruptorHandleQueue;
import com.je.cloud.disruptor.service.IHandleService;
import com.lmax.disruptor.WorkHandler;


/**
 * 消费者对象
 */
public class TaskEventConsumer implements WorkHandler<DisruptorHandleQueue> {

    // private SmsService smsService;
    //private MessageBean messageBean;
    // private static final Logger log = Logger.getLogger(TaskEventConsumer.class);


    @Override
    public void onEvent(DisruptorHandleQueue sms) throws Exception {
        try {
            IHandleService service = sms.getService();
            if (service != null) {
                service.exec(sms.getContext());
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
//        finally {

//        }
    }


}
