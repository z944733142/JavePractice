package app.xupt.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDEmo02 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 加载驱动类
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 建立连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8"
                ,"root","159630235z");
        connection.setAutoCommit(false);     // 手动提交
        Statement stmt = connection.createStatement();
        long start = System.currentTimeMillis();
        for(int i = 0 ; i < 20000; i++)
        {
            stmt.addBatch("insert into t_user (username,pwd,regTime) values ('张硕"+ i + "',6666,now())");
        }
        stmt.executeBatch();
        connection.commit();
        System.out.println("耗时" + (System.currentTimeMillis() - start) );
//        stmt.addBatch("delete from t_user where id > 5");   删库
//        stmt.executeBatch();
//        connection.commit();
        if(stmt != null)
        {
            stmt.close();
        }
        if (connection != null)
        {
            connection.close();
        }
    }
}
