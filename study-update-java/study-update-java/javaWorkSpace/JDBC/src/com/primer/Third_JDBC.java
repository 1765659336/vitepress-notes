package com.primer;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class Third_JDBC {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        // 1、注册驱动
        Driver driver = (Driver)aClass.newInstance();
        /* 2、得到连接:
         *   */
        String url = "jdbc:mysql://localhost:3306/bjpowernode";
        String username = "root";
        String password = "123456";
        DriverManager.registerDriver(driver);
        Connection connect = DriverManager.getConnection(url,username,password);
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
