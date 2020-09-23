package com.je.cloud.busi.test.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TestMapper {

    @Select("select * from user")
    List<Map<String, String>> selectTest();
}
