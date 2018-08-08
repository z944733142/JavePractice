package app.xupt.JDBC;

import java.sql.*;

public class ResultSetDemo01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

    // 加载驱动类
        Class.forName("com.mysql.cj.jdbc.Driver");
    // 建立连接
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8",
            "root","159630235z");
    String sql = "select id,username,pwd from t_user where id > ?";   // ? 占位符 防止注入
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setObject(1,6);
    ResultSet set = ps.executeQuery();
    while (set.next()){
        System.out.println(set.getObject(1) + " " +set.getObject(2)  + " " + set.getObject(3));
    }
    if(null != set)
    {
        set.close();
    }
    if(null != ps)
    {
        ps.close();
    }
    if (connection != null)
    {
        connection.close();
    }
    }
}
