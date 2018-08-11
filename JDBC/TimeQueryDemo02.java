package app.xupt.JDBC;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeQueryDemo02 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8"
                ,"root","159630235z");
        PreparedStatement PS = connection.prepareStatement("select * from t_user where Time > ? and Time < ?");  // * 挑出所有属性 Time只挑出Time属性
        PS.setTimestamp(1, new Timestamp(strDate("2018-8-8 14:30:00")));
        PS.setTimestamp(2, new Timestamp(strDate("2018-8-8 17:30:00")));  // 5分钟以内的信息
        ResultSet RS = PS.executeQuery();
        while(RS.next())
        {
            System.out.println(RS.getString("username") + " " + RS.getTimestamp("Time"));
        }
        PS.close();
       connection.close();
    }

    public static long strDate (String str)       // 格式化字符串转long类型数
    {
        try {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
