package com.je.cloud.busi.tasks.service;

import com.je.cloud.busi.tasks.domain.entity.TTask;
import com.je.cloud.busi.tasks.domain.entity.TTaskExample;

import java.util.List;

/**
*
* @Title:  TTaskService接口
* @Package com.je.cloud.busi.tasks.service
* @Description:    ..
* @author: shengteli
* @date:   2020-09-26
* @version V1.0
*/
public interface TTaskService {

	/**
	 * 插入数据
	 * @param model
	 */
    void save(TTask model);

    /**
     * 批量插入数据
     * @param models
     */
    void save(List<TTask> models);

    /**
     * 通过主鍵刪除
     * @param id
     */
    void deleteById(String id);

    /**
     * 更新
     * @param model
     */
    void update(TTask model);

    /**
     * 通过ID查找
     * @param id
     * @return
     */
    TTask findById(String id);

    /**
     * 根据条件查找
     * @param example
     * @return
     */
    List<TTask> findByExample(TTaskExample example);

}
