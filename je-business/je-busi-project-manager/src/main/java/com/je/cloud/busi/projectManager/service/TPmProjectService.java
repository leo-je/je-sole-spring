package com.je.cloud.busi.projectManager.service;

import com.je.cloud.busi.projectManager.domain.entity.TPmProject;
import com.je.cloud.busi.projectManager.domain.entity.TPmProjectExample;

import java.util.List;

/**
*
* @Title:  TPmProjectService接口
* @Package com.je.cloud.busi.projectManager.service
* @Description:    ..
* @author: shengteli
* @date:   2021-01-18
* @version V1.0
*/
public interface TPmProjectService {

	/**
	 * 插入数据
	 * @param model
	 */
    void save(TPmProject model);

    /**
     * 批量插入数据
     * @param models
     */
    void save(List<TPmProject> models);

    /**
     * 通过主鍵刪除
     * @param id
     */
    void deleteById(String id);

    /**
     * 更新
     * @param model
     */
    void update(TPmProject model);

    /**
     * 通过ID查找
     * @param id
     * @return
     */
    TPmProject findById(String id);

    /**
     * 根据条件查找
     * @param example
     * @return
     */
    List<TPmProject> findByExample(TPmProjectExample example);

}
