package com.je.cloud.busi.tasks.mapper;

import com.je.cloud.busi.tasks.domain.entity.TRuntimeProcess;
import com.je.cloud.busi.tasks.domain.entity.TRuntimeProcessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRuntimeProcessMapper {
    /**
     *
     * @param example
     */
    long countByExample(TRuntimeProcessExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(TRuntimeProcessExample example);

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
    int insert(TRuntimeProcess record);

    /**
     *
     * @param record
     */
    int insertSelective(TRuntimeProcess record);

    /**
     *
     * @param example
     */
    List<TRuntimeProcess> selectByExample(TRuntimeProcessExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    TRuntimeProcess selectByPrimaryKey(String id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") TRuntimeProcess record, @Param("example") TRuntimeProcessExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") TRuntimeProcess record, @Param("example") TRuntimeProcessExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(TRuntimeProcess record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(TRuntimeProcess record);
}