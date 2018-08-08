package app.xupt.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 和数据库链接
public class JDBCDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        // 建立连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8"
                ,"root","159630235z");
        System.out.println(connection);

    }
}
