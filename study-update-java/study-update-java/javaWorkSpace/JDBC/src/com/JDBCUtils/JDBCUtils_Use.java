/*
    @说明:JDBCUtils工具类的使用
*/
package com.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils_Use {
    public static void main(String[] args) {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from dept";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                System.out.println(result.getString(1)+"-"+result.getString(2)+"-"+result.getString(3));
            }
            JDBCUtils.close(result,statement,connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}