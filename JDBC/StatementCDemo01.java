package app.xupt.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// 执行和注入
public class StatementCDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 加载驱动类
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 建立连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8"
                ,"root","159630235z");

        Statement stmt = connection.createStatement();
//        String sql = "insert into t_user (username,pwd,regtime) values ('zz',6666,now())";
//        stmt.execute(sql);
        // 注入危险 删库 String sql = "delete from t_user where id=5 or 1=1";
//        String sql = "delete from t_user where id=5";
//        stmt.execute(sql);
        if (connection != null)
        {
            connection.close();
        }
    }
}
