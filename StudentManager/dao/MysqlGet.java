package com.dao;

import com.model.StudentInfo;
import com.model.StudentMark;
import com.model.TeacherInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static com.dao.MysqlUtil.close;
import static com.dao.MysqlUtil.getCon;

public class MysqlGet {
    Connection connection = null;

    public boolean checkMng(String user, String pwd){
        String sql = "select * from  manager where 1 = 1";
        try {
            PreparedStatement PS = connection.prepareStatement(sql);
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                if (RS.getString("mngUser").equals(user) && pwd.equals(RS.getString("mngPwd")))
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public  MysqlGet()
    {
        try {
            this.connection = getCon();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HashSet<StudentInfo> getStudentInfoSet () throws SQLException
    {

        String sql = "Select * from StudentInfo";
        PreparedStatement PS = connection.prepareStatement(sql);
        HashSet<StudentInfo> hashSet = new HashSet();
        ResultSet RS = PS.executeQuery();
            while (RS.next())
            {
                StudentInfo aStudentInfo = new StudentInfo();
                aStudentInfo.setStuId(RS.getInt("id"));
                aStudentInfo.setStuUser(RS.getString("stuUser"));
                aStudentInfo.setStuName(RS.getString("stuName"));
                aStudentInfo.setStuPwd(RS.getString("stuPwd"));
                aStudentInfo.setStuCla(RS.getInt("stuCla"));
                hashSet.add(aStudentInfo);
            }
            close(PS);
            return hashSet;

    }

    public HashSet<StudentMark> getStudentMark () throws SQLException {
        String sql = "Select * from studentmark";
        PreparedStatement PS = connection.prepareStatement(sql);
        HashSet<StudentMark> hashSet = new HashSet();
        ResultSet RS = PS.executeQuery();
        while (RS.next())
        {
            StudentMark studentMark = new StudentMark();
            studentMark.setId(RS.getInt("id"));
            studentMark.setEnglish(RS.getInt("english"));
            studentMark.setMath(RS.getInt("math"));
            studentMark.setChinese(RS.getInt("chinese"));
            studentMark.setJava(RS.getInt("java"));
            studentMark.setName(RS.getString("stuname"));
            studentMark.sum();
            hashSet.add(studentMark);
        }
        close(PS);
        return hashSet;
    }

    public HashSet<TeacherInfo> getTeacherInfo () throws SQLException {
        String sql = "Select * from teacher";
        PreparedStatement PS = connection.prepareStatement(sql);
        HashSet<TeacherInfo> hashSet = new HashSet();
        ResultSet RS = PS.executeQuery();
        while (RS.next())
        {
            TeacherInfo teacherInfo = new TeacherInfo();
            teacherInfo.setId(RS.getInt("id"));
            teacherInfo.setTchName(RS.getString("TchName"));
            teacherInfo.setTchUser(RS.getString("TchUser"));
            teacherInfo.setTchPwd(RS.getString("TchPwd"));
            teacherInfo.setTchCla(RS.getInt("TchCla"));
            hashSet.add(teacherInfo);
        }
        close(PS);
        return hashSet;
    }
}
