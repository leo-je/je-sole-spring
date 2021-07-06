package com.je.cloud.busi.projectManager.mapper;

import com.je.cloud.busi.projectManager.domain.entity.TPmProject;
import com.je.cloud.busi.projectManager.domain.entity.TPmProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPmProjectMapper {
    /**
     *
     * @param example
     */
    long countByExample(TPmProjectExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(TPmProjectExample example);

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
    int insert(TPmProject record);

    /**
     *
     * @param record
     */
    int insertSelective(TPmProject record);

    /**
     *
     * @param example
     */
    List<TPmProject> selectByExample(TPmProjectExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    TPmProject selectByPrimaryKey(String id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") TPmProject record, @Param("example") TPmProjectExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") TPmProject record, @Param("example") TPmProjectExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(TPmProject record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(TPmProject record);
}