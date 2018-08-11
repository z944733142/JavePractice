package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlUtil {

    private static final String CLASSLOAD = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PWD = "159630235z";

    public static Connection getCon() throws ClassNotFoundException, SQLException {
        Class.forName(CLASSLOAD);
        return DriverManager.getConnection(URL, USER, PWD);
    }

    public static String insert(String table, String item, String value) {
        return "insert into " + table + "(" + item + ") values " + "(" + value + ")";
    }

    public static void close (Statement... c)
    {
        for (Statement sta:c
             ) {
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close (Connection... c)
    {
        for (Connection con: c
             ) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
