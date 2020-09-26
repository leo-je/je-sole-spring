package com.je.cloud.busi.tasks.service;

import com.je.cloud.busi.tasks.domain.entity.TaskHistory;
import com.je.cloud.busi.tasks.domain.entity.TaskHistoryExample;

import java.util.List;

/**
*
* @Title:  TaskHistoryService接口
* @Package com.je.cloud.busi.tasks.service
* @Description:    ..
* @author: shengteli
* @date:   2020-09-26
* @version V1.0
*/
public interface TaskHistoryService {

	/**
	 * 插入数据
	 * @param model
	 */
    void save(TaskHistory model);

    /**
     * 批量插入数据
     * @param models
     */
    void save(List<TaskHistory> models);

    /**
     * 通过主鍵刪除
     * @param id
     */
    void deleteById(String id);

    /**
     * 更新
     * @param model
     */
    void update(TaskHistory model);

    /**
     * 通过ID查找
     * @param id
     * @return
     */
    TaskHistory findById(String id);

    /**
     * 根据条件查找
     * @param example
     * @return
     */
    List<TaskHistory> findByExample(TaskHistoryExample example);

}
