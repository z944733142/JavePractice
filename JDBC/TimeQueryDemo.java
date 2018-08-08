package app.xupt.JDBC;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeQueryDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8"
                ,"root","159630235z");
        PreparedStatement PS = connection.prepareStatement("select * from t_user where Time > ? and Time < ?");  // * 挑出所有属性 Time只挑出Time属性
        PS.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
        PS.setTimestamp(2, new Timestamp(System.currentTimeMillis() + 300 * 1000));  // 5分钟以内的信息
        ResultSet RS = PS.executeQuery();
        while(RS.next())
        {
            System.out.println(RS.getString("username")  + " " +  RS.getTimestamp("Time") );
        }

    }
}
