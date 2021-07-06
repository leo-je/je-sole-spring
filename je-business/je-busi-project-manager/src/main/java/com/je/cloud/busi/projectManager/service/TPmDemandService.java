package com.je.cloud.busi.projectManager.service;

import com.je.cloud.busi.projectManager.domain.entity.TPmDemand;
import com.je.cloud.busi.projectManager.domain.entity.TPmDemandExample;

import java.util.List;

/**
*
* @Title:  TPmDemandService接口
* @Package com.je.cloud.busi.projectManager.service
* @Description:    ..
* @author: shengteli
* @date:   2021-01-20
* @version V1.0
*/
public interface TPmDemandService {

	/**
	 * 插入数据
	 * @param model
	 */
    void save(TPmDemand model);

    /**
     * 批量插入数据
     * @param models
     */
    void save(List<TPmDemand> models);

    /**
     * 通过主鍵刪除
     * @param id
     */
    void deleteById(String id);

    /**
     * 更新
     * @param model
     */
    void update(TPmDemand model);

    /**
     * 通过ID查找
     * @param id
     * @return
     */
    TPmDemand findById(String id);

    /**
     * 根据条件查找
     * @param example
     * @return
     */
    List<TPmDemand> findByExample(TPmDemandExample example);

}
