package com.je.cloud.busi.projectManager.service;

import com.je.cloud.busi.projectManager.domain.entity.TPmProgram;
import com.je.cloud.busi.projectManager.domain.entity.TPmProgramExample;

import java.util.List;

/**
*
* @Title:  TPmProgramService接口
* @Package com.je.cloud.busi.projectManager.service
* @Description:    ..
* @author: shengteli
* @date:   2021-01-19
* @version V1.0
*/
public interface TPmProgramService {

	/**
	 * 插入数据
	 * @param model
	 */
    void save(TPmProgram model);

    /**
     * 批量插入数据
     * @param models
     */
    void save(List<TPmProgram> models);

    /**
     * 通过主鍵刪除
     * @param id
     */
    void deleteById(String id);

    /**
     * 更新
     * @param model
     */
    void update(TPmProgram model);

    /**
     * 通过ID查找
     * @param id
     * @return
     */
    TPmProgram findById(String id);

    /**
     * 根据条件查找
     * @param example
     * @return
     */
    List<TPmProgram> findByExample(TPmProgramExample example);

}
