package com.primer;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.Properties;

public class First_JDBC {
    public static void main(String[] args) throws SQLException {
        // 1、注册驱动
        Driver driver = new Driver();
        /* 2、得到连接:
         *   */
        String url = "jdbc:mysql://localhost:3306/bjpowernode";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");
        Connection connect = driver.connect(url, properties);
        // 3、执行sql
        String sql = "select * from dept";
        // 接收返回的结果对象
        Statement statement = connect.createStatement();
        ResultSet result = statement.executeQuery(sql);
        ResultSetMetaData rsmd = result.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (result.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = result.getString(i);
                System.out.print("[列名:" + rsmd.getColumnName(i) + "](值:" + columnValue + ")");
            }
            System.out.println("");
        }
        // 4、关闭连接
        statement.close();
        connect.close();
    }
}
