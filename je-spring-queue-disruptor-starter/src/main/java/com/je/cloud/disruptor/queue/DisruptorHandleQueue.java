package com.je.cloud.disruptor.queue;

import com.je.cloud.base.exception.ApplicationException;
import com.je.cloud.base.utils.SpringContextHolder;
import com.je.cloud.disruptor.service.IHandleService;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ConcurrentHashMap;

public class DisruptorHandleQueue {

    private ConcurrentHashMap<String, Object> context;

    private String name;

    private String serviceBeanName;

    private Class<? extends IHandleService> serviceType;


    public DisruptorHandleQueue() {

    }

    public DisruptorHandleQueue(String name, String serviceBeanName, ConcurrentHashMap<String, Object> context) {
        this.name = name;
        this.serviceBeanName = serviceBeanName;
        this.context = context;
    }

    public DisruptorHandleQueue(String name, Class<? extends IHandleService> serviceType, ConcurrentHashMap<String, Object> context) {
        this.name = name;
        this.serviceType = serviceType;
        this.context = context;
    }

    public Class<? extends IHandleService> getServiceType() {
        return serviceType;
    }

    public void setServiceType(Class<? extends IHandleService> serviceType) {
        this.serviceType = serviceType;
    }

    public IHandleService getService() {
        IHandleService bean = null;
        if (serviceType != null) {
            bean = SpringContextHolder.getBean(serviceType);
        }
        if (bean == null && StringUtils.isNotBlank(getServiceBeanName())) {
            bean = SpringContextHolder.getBean(getServiceBeanName());
        }
        if (bean == null) {
            throw new ApplicationException("未找到处理类");
        }
        return bean;
    }


    public ConcurrentHashMap getContext() {
        return context;
    }

    public void setContext(ConcurrentHashMap context) {
        this.context = context;
    }

    public String getServiceBeanName() {
        return serviceBeanName;
    }

    public void setServiceBeanName(String serviceBeanName) {
        this.serviceBeanName = serviceBeanName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
