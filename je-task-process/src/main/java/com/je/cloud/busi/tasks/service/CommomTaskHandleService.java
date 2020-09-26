package com.je.cloud.busi.tasks.service;

import com.je.cloud.busi.tasks.domain.entity.TTask;
import org.springframework.scheduling.annotation.Async;

public interface CommomTaskHandleService {
    @Async
    void execute(TTask e);
}
