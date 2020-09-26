package com.je.cloud.busi.tasks.service;

import com.je.cloud.busi.tasks.domain.entity.TRuntimeProcess;
import com.je.cloud.busi.tasks.domain.entity.TRuntimeProcessExample;

import java.util.List;

/**
*
* @Title:  TRuntimeProcessService接口
* @Package com.je.cloud.busi.tasks.service
* @Description:    ..
* @author: shengteli
* @date:   2020-09-26
* @version V1.0
*/
public interface TRuntimeProcessService {

	/**
	 * 插入数据
	 * @param model
	 */
    void save(TRuntimeProcess model);

    /**
     * 批量插入数据
     * @param models
     */
    void save(List<TRuntimeProcess> models);

    /**
     * 通过主鍵刪除
     * @param id
     */
    void deleteById(String id);

    /**
     * 更新
     * @param model
     */
    void update(TRuntimeProcess model);

    /**
     * 通过ID查找
     * @param id
     * @return
     */
    TRuntimeProcess findById(String id);

    /**
     * 根据条件查找
     * @param example
     * @return
     */
    List<TRuntimeProcess> findByExample(TRuntimeProcessExample example);

}
