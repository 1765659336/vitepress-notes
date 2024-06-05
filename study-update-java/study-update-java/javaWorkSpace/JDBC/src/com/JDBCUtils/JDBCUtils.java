/*
    @说明:封装一个JDBC的工具类
    @作用:连接数据库，关闭数据库
*/
package com.JDBCUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String user = "";
    private static String password = "";
    private static String url = "";
    private static String driver = "";

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\mysql.init"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            // 实际开发时，经常将编译异常转为运行异常，调用者就可以选择默认处理和自己处理
            throw new RuntimeException(e);
        }
    }

    // 建立连接
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 关闭相关资源
    public static void close(ResultSet set, Statement statement, Connection connection){
        try {
            if(set != null){
                set.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
