package com.je.cloud.busi.common.sql.controller;

import com.je.cloud.base.exception.ApplicationException;
import com.je.cloud.busi.common.sql.mapper.xml.SqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comm/sql/")
public class SqlTestController {

    @Autowired
    SqlMapper sqlMapper;


    @GetMapping("/exec")
    public Object exec(HttpServletResponse response, String username, String password) {
        String sql = "update user set id = '12' where id = '111'";
        sql = sql.trim();
        if (sql.startsWith("select") || sql.startsWith("Select")) {
            return sqlMapper.execSelect(sql);
        } else if (sql.startsWith("update") || sql.startsWith("Update")) {
            return sqlMapper.execUpdate(sql);
        } else if (sql.startsWith("insert") || sql.startsWith("Insert")) {
            return sqlMapper.execInset(sql);
        } else if (sql.startsWith("delete") || sql.startsWith("Delete")) {
            return sqlMapper.execDel(sql);
        }
        return "[]";
    }
}
