package com.je.cloud.busi.projectManager.mapper;

import com.je.cloud.busi.projectManager.domain.entity.TPmProgram;
import com.je.cloud.busi.projectManager.domain.entity.TPmProgramExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPmProgramMapper {
    /**
     *
     * @param example
     */
    long countByExample(TPmProgramExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(TPmProgramExample example);

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
    int insert(TPmProgram record);

    /**
     *
     * @param record
     */
    int insertSelective(TPmProgram record);

    /**
     *
     * @param example
     */
    List<TPmProgram> selectByExample(TPmProgramExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    TPmProgram selectByPrimaryKey(String id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") TPmProgram record, @Param("example") TPmProgramExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") TPmProgram record, @Param("example") TPmProgramExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(TPmProgram record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(TPmProgram record);
}