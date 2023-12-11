package com.example.service;

import com.example.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TopicBackEnd {
    public static int login(String timu, String asA, String asB, String asC, String asD, String right) throws SQLException {

        Connection connection = JdbcUtil.getConnection();
        String sql2 = "INSERT INTO topic (topic, bA, bB, bC, bD,R) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement2 = null;
        Integer count = null;
        try {
            statement2 = connection.prepareCall(sql2);
            statement2.setString(1, timu);   // 将题目设置为第一个参数的值
            statement2.setString(2, asA);    // 将选项A设置为第二个参数的值
            statement2.setString(3, asB);    // 将选项B设置为第三个参数的值
            statement2.setString(4, asC);    // 将选项C设置为第四个参数的值
            statement2.setString(5, asD);    // 将选项D设置为第五个参数的值
            statement2.setString(6, right);   // 将标准答案设置为第一个参数的值
            count = statement2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            statement2.close();
            connection.close();
        }

        return count;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(login("1", "1", "1", "1", "1", "1"));
    }
}