package com.je.cloud.busi.scheduler.mapper;

import com.je.cloud.quartz.entity.TaskInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TaskInfoMapper {


    @Select("select * from t_task_info where id = #{id}")
    TaskInfo selectById(@Param("id") String id);

    @Select("select * from t_task_info ")
    List<TaskInfo> list();

    int removeBatch(String[] ids);

    int update(TaskInfo taskScheduleJob);

    int save(TaskInfo task);

    int delete(String id);
}
