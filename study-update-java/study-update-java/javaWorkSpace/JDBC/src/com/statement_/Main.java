/*
 * @说明：演示statement的SQL注入问题
 * */
package com.statement_;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
         * next() 会将空格作为一次输入，如果直接复制粘贴1' or，会被当成两次输入，然后程序会立刻执行，报错
         * nextLine() 是接收一行
         * */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
//        String admin_name = scanner.next();
        String admin_name = scanner.nextLine();
        System.out.println("请输入密码");
//        String admin_pwd = scanner.next();
        String admin_pwd = scanner.nextLine();
        // 1、注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        /* 2、得到连接:
         *   */
        String url = "jdbc:mysql://localhost:3306/bjpowernode";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3、执行sql
        String sql = "select name,pwd from admin where name = '" + admin_name + "' and pwd = '" + admin_pwd + "'";
        System.out.println(sql);
        // 接收返回的结果对象
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        ResultSetMetaData rsmd = result.getMetaData();
        if (result.next()) {
            // 查询到用户
            System.out.println("登录成功");
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = result.getString(i);
                System.out.print("[列名:" + rsmd.getColumnName(i) + "](值:" + columnValue + ")");
            }
            System.out.println("");
        } else {
            System.out.println("登录失败");
        }
        // 4、关闭连接
        statement.close();
        connection.close();
        result.close();
        scanner.close();
    }
}
