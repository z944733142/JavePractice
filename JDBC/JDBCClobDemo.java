package app.xupt.JDBC;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCClobDemo {
    public static void main(String[] args) throws Exception{
        // 加载驱动类
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 建立连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8",
                "root","159630235z");
        String sql = "insert into t_user(aTest) values(?)";   // ? 占位符 防止注入
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setClob(1, new BufferedReader
                (new InputStreamReader(new ByteArrayInputStream("aaaabbbbbb".getBytes()))));
    }
}
