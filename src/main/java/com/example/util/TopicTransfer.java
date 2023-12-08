package com.example.util;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    private int num;

    private ArrayList<String> r=new ArrayList<>();


    Connection connection= JdbcUtil.getConnection();
    String sqlF="select * from topic where id = ?;";
    PreparedStatement preparedStatement= connection.prepareStatement(sqlF);
    ResultSet resultSet;


    public TopicTransfer(int index,int num) throws SQLException {
        this.num=num;
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
            r.add(resultSet.getString("R"));
        }
        preparedStatement.clearParameters();

    }
    public double r(String option){
        for (String s : r) {
            if (option.equals(s)){
                return (double) 100 /num;
            }
        }
        return 0;
    }
}
