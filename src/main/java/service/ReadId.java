package service;

import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadId {
    public static String getid() throws SQLException {
        String a=null;
        Connection connection= JdbcUtil.getConnection();
        String sql="select account from student where id=1";
        PreparedStatement statement=null;
        ResultSet rs=null;
        try{
            statement=connection.prepareCall(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                a=rs.getString(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            rs.close();
            connection.close();
            statement.close();
        }
        return  a;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getid());
    }

}
