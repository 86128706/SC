package com.example.service;

import com.example.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TopicBackEnd {
    public static void login(String timu,String asA,String asB,String asC, String asD,String right) throws SQLException {

        //这里要写一堆该死的空值判断，我全放到前端行不行
//        if (name == null || name.trim().equals("")) {
//            return false;
//        }
//        else if (name == null || name.trim().equals("")) {
//            return false;
//        }

        //链接数据库
        Connection connection= JdbcUtil.getConnection();

        //获得需要填入表格内的第一个数据
        // 构建 SQL 查询语句，查询 topic 表格的记录总数
        String sql = "SELECT COUNT(*) FROM topic";
        // 创建 PreparedStatement 对象并执行查询
        PreparedStatement statement1 = connection.prepareStatement(sql);
        ResultSet resultSet = statement1.executeQuery();
        // 获取查询结果并返回数据行数count
        int count = 0;
        if (resultSet.next()) {
            count = resultSet.getInt(1);
        }
        String strNum = String.valueOf(count);
        statement1.close();  // 关闭 PreparedStatement 对象


        //将数据分别填入对应的表格内容
        // 构建 SQL 语句插入数据
        String sql2 = "INSERT INTO topic (id,topic, bA, bB, bC, bD,R) VALUES (?, ?, ?, ?, ?, ?, ?)";
        // 在上面的 SQL 语句中，插入了一条新记录到名为“topic”的表中，包括了题目和四个选项，分别用占位符“?”表示
        // 创建 PreparedStatement 对象并设置参数
        PreparedStatement statement2 = connection.prepareStatement(sql2);
        statement2.setString(1, strNum);   // 将题目设置为第一个参数的值
        statement2.setString(2, timu);   // 将题目设置为第一个参数的值
        statement2.setString(3, asA);    // 将选项A设置为第二个参数的值
        statement2.setString(4, asB);    // 将选项B设置为第三个参数的值
        statement2.setString(5, asC);    // 将选项C设置为第四个参数的值
        statement2.setString(6, asD);    // 将选项D设置为第五个参数的值
        statement2.setString(7, right);   // 将标准答案设置为第一个参数的值

        // 执行 SQL 插入操作
        statement2.executeUpdate();  // 执行 SQL 插入操作，将带有题目和选项的新记录插入到数据库表中

        // 关闭连接和 statement 对象
        statement2.close();  // 关闭 PreparedStatement 对象

        connection.close();  // 关闭数据库连接
    }
}
