package com.je.cloud.busi.tasks.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CommTaskMapper {

    @Select("" +
            "<script>" +
            "{ " +
            " call ${process}(#{id,mode=IN,jdbcType=VARCHAR}) " +
            " }" +
            "</script>")
    int callProcess(@Param("process") String process, @Param("id") String id);
}
