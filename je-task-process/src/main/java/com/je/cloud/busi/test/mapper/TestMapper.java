package com.je.cloud.busi.test.mapper;

import com.je.cloud.busi.test.entity.Article;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TestMapper {

    @Select("select * from article")
    List<Article> selectTest();
}
