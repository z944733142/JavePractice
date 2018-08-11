package com.model;

public class StudentInfo {
    private int stuId;
    private int stuCla;
    private String stuName;
    private String stuUser;
    private String stuPwd;

    public StudentInfo()
    {

    }
    public StudentInfo(int stuId, int stuCla, String stuName, String stuUser, String stuPwd) {
        this.stuId = stuId;
        this.stuCla = stuCla;
        this.stuName = stuName;
        this.stuUser = stuUser;
        this.stuPwd = stuPwd;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public void setStuCla(int stuCla) {
        this.stuCla = stuCla;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuUser(String stuUser) {
        this.stuUser = stuUser;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }

    public int getStuId() {
        return stuId;
    }

    public int getStuCla() {
        return stuCla;
    }

    public String getStuName() {
        return stuName;
    }

    public String getStuUser() {
        return stuUser;
    }

    public String getStuPwd() {
        return stuPwd;
    }
}

