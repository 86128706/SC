package com.example.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TopicTransfer {
    //将题目传输到ChosePage
        private String situmon;
        private String OptionsA;
        private String OptionsB;
        private String OptionsC;

        private String OptionsD;

        public String getSitumon() {
            return situmon;
        }

        public void setSitumon(String situmon) {
            this.situmon = situmon;
        }

        public String getOptionsA() {
            return OptionsA;
        }

        public void setOptionsA(String optionsA) {
            OptionsA = optionsA;
        }

        public String getOptionsB() {
            return OptionsB;
        }

        public void setOptionsB(String optionsB) {
            OptionsB = optionsB;
        }

        public String getOptionsC() {
            return OptionsC;
        }

        public void setOptionsC(String optionsC) {
            OptionsC = optionsC;
        }

        public String getOptionsD() {
            return OptionsD;
        }

        public void setOptionsD(String optionsD) {
            OptionsD = optionsD;
        }


    public TopicTransfer() throws SQLException {
        Connection connection= JdbcUtil.getConnection();
        Statement statement = connection.createStatement();
        String sql="select * from topic";
        ResultSet resultSet= statement.executeQuery(sql);
        while (resultSet.next()){
            setSitumon(resultSet.getString("topic"));
            setOptionsA(resultSet.getString("bA"));
            setOptionsB(resultSet.getString("bB"));
            setOptionsC(resultSet.getString("bC"));
            setOptionsD(resultSet.getString("bD"));
        }
    }
}
