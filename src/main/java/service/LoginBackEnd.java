package service;

import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginBackEnd {
    //1成功0失败
    public static int login(String name) throws SQLException {
        //暂时不懂什么意思
        if (name == null || name.trim().equals("")) {
            return 0;
        }
        Integer name=null;
        //链接数据库？
        Connection connection= JdbcUtil.getConnection();
        //数据库查询表 查询？？？？？？
        String sql= "select name from single where account=?";
        //？
        PreparedStatement statement=null;
        try{
            statement=connection.prepareCall(sql);
            statement.setString(1,name);
            statement.setString(2, Md5.md5Hash(password));
            rs=statement.executeQuery();
            while(rs.next()){
                id= rs.getInt("id");
                type=rs.getInt("type");
            }
            if(id==null){
                return -1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            rs.close();
            statement.close();
            connection.close();
        }
        return type;
    }
    public static void main(String[] args) throws SQLException{
        System.out.println(login("1","1"));
    }
}
