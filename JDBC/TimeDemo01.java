package app.xupt.JDBC;

import java.sql.*;

public class TimeDemo01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 加载驱动类
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 建立连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8"
                ,"root","159630235z");
        connection.setAutoCommit(false);
        PreparedStatement stmt = null;
        for(int i = 0 ; i < 20000; i++)
        {
            long rand = (long) (System.currentTimeMillis() + Math.random() * 3600 * 1000 * 24);
            stmt = connection.prepareStatement("insert into t_user (username,pwd,Time,date,time1) values ('zz',6666,?,?,?)");
            stmt.setTime(3, new java.sql.Time(rand));
            stmt.setTimestamp(1, new java.sql.Timestamp(rand));
            stmt.setDate(2, new java.sql.Date(rand));
            stmt.execute();
        }
        connection.commit();
        stmt.close();
        connection.close();
    }
}
