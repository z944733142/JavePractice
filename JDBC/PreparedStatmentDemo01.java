package app.xupt.JDBC;

import java.sql.*;

public class PreparedStatmentDemo01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        // 建立连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8",
                "root","159630235z");
        String sql = "insert into t_user(username,pwd,regtime) values(?,?,?)";   // ? 占位符 防止注入
        PreparedStatement ps = connection.prepareStatement(sql);
//        ps.setString(1, "张硕");    // 第一个问号
//        ps.setString(2, "111111"); // 索引从1开始
//        ps.setDate(3, new Date(System.currentTimeMillis()));
        ps.setObject(1, "ss2");
        ps.setObject(2, "121212");
        ps.setObject(3, new Date(System.currentTimeMillis()));
//        ps.execute();
        System.out.println(ps.executeUpdate());
        if(ps != null)
        {
            ps.close();
        }
        if (connection != null)
        {
            connection.close();
        }
    }
}
