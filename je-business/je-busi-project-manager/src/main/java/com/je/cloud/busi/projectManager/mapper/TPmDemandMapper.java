package com.je.cloud.busi.projectManager.mapper;

import com.je.cloud.busi.projectManager.domain.entity.TPmDemand;
import com.je.cloud.busi.projectManager.domain.entity.TPmDemandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPmDemandMapper {
    /**
     *
     * @param example
     */
    long countByExample(TPmDemandExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(TPmDemandExample example);

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
    int insert(TPmDemand record);

    /**
     *
     * @param record
     */
    int insertSelective(TPmDemand record);

    /**
     *
     * @param example
     */
    List<TPmDemand> selectByExampleWithBLOBs(TPmDemandExample example);

    /**
     *
     * @param example
     */
    List<TPmDemand> selectByExample(TPmDemandExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    TPmDemand selectByPrimaryKey(String id);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") TPmDemand record, @Param("example") TPmDemandExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExampleWithBLOBs(@Param("record") TPmDemand record, @Param("example") TPmDemandExample example);

    /**
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") TPmDemand record, @Param("example") TPmDemandExample example);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(TPmDemand record);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeyWithBLOBs(TPmDemand record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(TPmDemand record);
}