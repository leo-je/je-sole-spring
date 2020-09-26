package com.je.cloud.busi.tasks.mapper;

import com.je.cloud.busi.tasks.domain.entity.TaskHistory;
import com.je.cloud.busi.tasks.domain.entity.TaskHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskHistoryMapper {
    /**
     *
     * @param example
     */
    long countByExample(TaskHistoryExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(TaskHistoryExample example);

    /**
     * 根据主键删除数据库的记录
     *
     * @param id
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(TaskHistory record);

    /**
     *
     * @param record
     */
    int insertSelective(TaskHistory record);

    /**
     *
     * @param example
     */
    List<TaskHistory> selectByExample(TaskHistoryExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    TaskHistory selectByPrimaryKey(String id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") TaskHistory record, @Param("example") TaskHistoryExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") TaskHistory record, @Param("example") TaskHistoryExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(TaskHistory record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(TaskHistory record);
}