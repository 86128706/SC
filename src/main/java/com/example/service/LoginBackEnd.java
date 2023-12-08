package com.example.service;

import com.example.util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginBackEnd {
    public static boolean login(String name) throws SQLException {
        if (name == null || name.trim().equals("")) {
            return false;
        }
        //链接数据库
        Connection connection= JdbcUtil.getConnection();
        //数据库查询表
        String sql= "select account from student";
        Statement statement=connection.createStatement();
        ResultSet rs=statement.executeQuery(sql);
        while (rs.next()){
            String account = rs.getString("account");
            if (name.equals(account)){
                return true;
            }
        }
        rs.close();
        statement.close();
        connection.close();
        return false;
    }
}
