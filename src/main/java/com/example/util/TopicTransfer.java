package com.example.util;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TopicTransfer {
    //将题目传输到ChosePage
    @Setter
    @Getter
    private String situmon;

    @Setter
    @Getter
    private String OptionsA;

    @Setter
    @Getter
    private String OptionsB;

    @Setter
    @Getter
    private String OptionsC;

    @Setter
    @Getter
    private String OptionsD;



    Connection connection= JdbcUtil.getConnection();
    String sqlF="select * from topic where id = ?;";
    PreparedStatement preparedStatement= connection.prepareStatement(sqlF);
    ResultSet resultSet;


    public TopicTransfer(int index) throws SQLException {
        find(index);
    }
    public void find(int index) throws SQLException {
        preparedStatement.setInt(1, index);
        resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
            setSitumon(resultSet.getString("topic"));
            setOptionsA(resultSet.getString("bA"));
            setOptionsB(resultSet.getString("bB"));
            setOptionsC(resultSet.getString("bC"));
            setOptionsD(resultSet.getString("bD"));
        }
        preparedStatement.clearParameters();
    }
}
