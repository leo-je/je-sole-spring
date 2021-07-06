package com.je.cloud.busi.tasks.mapper;

import com.je.cloud.busi.tasks.domain.entity.TTask;
import com.je.cloud.busi.tasks.domain.entity.TTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTaskMapper {
    /**
     *
     * @param example
     */
    long countByExample(TTaskExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(TTaskExample example);

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
    int insert(TTask record);

    /**
     *
     * @param record
     */
    int insertSelective(TTask record);

    /**
     *
     * @param example
     */
    List<TTask> selectByExample(TTaskExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    TTask selectByPrimaryKey(String id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") TTask record, @Param("example") TTaskExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") TTask record, @Param("example") TTaskExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(TTask record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(TTask record);
}