package com.je.cloud.busi.tasks.service;

import com.je.cloud.busi.tasks.domain.entity.TProcessInfo;
import com.je.cloud.busi.tasks.domain.entity.TProcessInfoExample;

import java.util.List;

/**
*
* @Title:  TProcessInfoService接口
* @Package com.je.cloud.busi.tasks.service
* @Description:    ..
* @author: shengteli
* @date:   2020-09-25
* @version V1.0
*/
public interface TProcessInfoService {

	/**
	 * 插入数据
	 * @param model
	 */
    void save(TProcessInfo model);

    /**
     * 批量插入数据
     * @param models
     */
    void save(List<TProcessInfo> models);

    /**
     * 通过主鍵刪除
     * @param id
     */
    void deleteById(String id);

    /**
     * 更新
     * @param model
     */
    void update(TProcessInfo model);

    /**
     * 通过ID查找
     * @param id
     * @return
     */
    TProcessInfo findById(String id);

    /**
     * 根据条件查找
     * @param example
     * @return
     */
    List<TProcessInfo> findByExample(TProcessInfoExample example);

}
