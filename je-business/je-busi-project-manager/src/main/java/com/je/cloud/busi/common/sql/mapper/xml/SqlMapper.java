package com.je.cloud.busi.common.sql.mapper.xml;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface SqlMapper {

    @Select("<script>" +
            "${sql}" +
            "</script>")
    List<Map<String, Object>> execSelect(String sql);

    @Update("<script>" +
            "${sql}" +
            "</script>")
    long execUpdate(String sql);

    @Delete("<script>" +
            "${sql}" +
            "</script>")
    long execDel(String sql);

    @Insert("<script>" +
            "${sql}" +
            "</script>")
    long execInset(String sql);

}
