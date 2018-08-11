package com.dao;

import com.model.StudentInfo;
import com.model.StudentMark;
import com.model.TeacherInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;

import static com.dao.MysqlUtil.close;
import static com.dao.MysqlUtil.getCon;

public class MysqlSet {
    Connection connection;
    private static final String STUINFOSQL = "insert into studentInfo (id,stuUser, stuName, stuPwd, stuCla) values (?,?,?,?,?)";
    private static final String TEAINFOSQL = "insert into teacher (id,tchUser, tchName, tchPwd, tchCla) values (?,?,?,?,?)";
    private static final String STUMARKSQL = "insert into studentMark (id, stuname,english, math, chinese, java) values (?,?,?,?,?,?)";


    public MysqlSet() {
        try {
            connection = getCon();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean setStudentInfo(HashSet<StudentInfo> hashSet) throws SQLException {
        PreparedStatement PS = connection.prepareStatement(STUINFOSQL);
        connection.setAutoCommit(false);
        Iterator<StudentInfo> ite = hashSet.iterator();
        while (ite.hasNext()) {
            StudentInfo studentInfo = ite.next();
            PS.setInt(1, studentInfo.getStuId());
            PS.setString(2, studentInfo.getStuUser());
            PS.setString(3, studentInfo.getStuName());
            PS.setString(4, studentInfo.getStuPwd());
            PS.setInt(5, studentInfo.getStuCla());
            PS.execute();
        }
        connection.commit();

        return true;
    }

    public boolean setTeacherInfo(HashSet<TeacherInfo> hashSet) throws SQLException {
        String sql = "";
        PreparedStatement PS = connection.prepareStatement(TEAINFOSQL);
        connection.setAutoCommit(false);
        Iterator<TeacherInfo> ite = hashSet.iterator();
        while (ite.hasNext()) {
            TeacherInfo teacherInfo = ite.next();
            PS.setInt(1, teacherInfo.getId());
            PS.setString(2, teacherInfo.getTchUser());
            PS.setString(3, teacherInfo.getTchName());
            PS.setString(4, teacherInfo.getTchPwd());
            PS.setInt(5, teacherInfo.getTchCla());
            PS.execute();
        }
        connection.commit();
        close(PS);

        return true;
    }


    public boolean setStudentMark(HashSet<StudentMark> hashSet) throws SQLException {
        PreparedStatement PS = connection.prepareStatement(STUMARKSQL);
        connection.setAutoCommit(false);
        Iterator<StudentMark> ite = hashSet.iterator();
        while (ite.hasNext()) {
            StudentMark studentMark = ite.next();
            PS.setInt(1, studentMark.getId());
            PS.setString(2, studentMark.getName());
            PS.setInt(3, studentMark.getEnglish());
            PS.setInt(4, studentMark.getMath());
            PS.setInt(5, studentMark.getChinese());
            PS.setInt(6, studentMark.getJava());
            PS.execute();
        }
        connection.commit();

        return true;
    }

    public void updatePwd(int key, String password, int id) throws SQLException {
        String table = null;
        String pwd = null;
        switch (key) {
            case 1:
                table = "manager";
                pwd = "pwd";
                break;
            case 2:
                table = "teacher";
                pwd = "tchPwd";
                break;
            case 3:
                table = "studentInfo";
                pwd = "stuPwd";
                break;
        }

        PreparedStatement PS = connection.prepareStatement("update " + table + " set " + pwd + " = " + password + " where id = " + id);
        PS.execute();

        PS.close();

    }

    public boolean deleteStu(int id) throws SQLException {
        PreparedStatement PS = connection.prepareStatement("delete  from studentInfo where id = " + id );
        connection.setAutoCommit(false);
        PS.execute();
        connection.commit();
        return true;
    }

    public boolean deleteStumark(int id) throws SQLException {
        PreparedStatement PS = connection.prepareStatement("delete  from studentmark where id = " + id );
        connection.setAutoCommit(false);
        PS.execute();
        connection.commit();
        return true;
    }

    public boolean deleteThc(int id) throws SQLException {
        PreparedStatement PS = connection.prepareStatement("delete  from teacher where id = " + id);
        connection.setAutoCommit(false);
        PS.execute();
        connection.commit();
        return true;
    }
}
