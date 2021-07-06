package com.je.cloud.busi.tasks.mapper;

import com.je.cloud.busi.tasks.domain.entity.TProcessInfo;
import com.je.cloud.busi.tasks.domain.entity.TProcessInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProcessInfoMapper {
    /**
     *
     * @param example
     */
    long countByExample(TProcessInfoExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(TProcessInfoExample example);

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
    int insert(TProcessInfo record);

    /**
     *
     * @param record
     */
    int insertSelective(TProcessInfo record);

    /**
     *
     * @param example
     */
    List<TProcessInfo> selectByExample(TProcessInfoExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    TProcessInfo selectByPrimaryKey(String id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") TProcessInfo record, @Param("example") TProcessInfoExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") TProcessInfo record, @Param("example") TProcessInfoExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(TProcessInfo record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(TProcessInfo record);
}