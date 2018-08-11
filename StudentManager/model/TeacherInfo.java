package com.model;

public class TeacherInfo {
    private int id;
    private int tchCla;
    private String tchName;
    private String tchUser;
    private String tchPwd;

    public TeacherInfo(){

    }
    public TeacherInfo(int id, int tchCla, String tchName, String tchUser, String tchPwd) {
        this.id = id;
        this.tchCla = tchCla;
        this.tchName = tchName;
        this.tchUser = tchUser;
        this.tchPwd = tchPwd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTchCla(int tchCla) {
        this.tchCla = tchCla;
    }

    public void setTchName(String tchName) {
        this.tchName = tchName;
    }

    public void setTchUser(String tchUser) {
        this.tchUser = tchUser;
    }

    public void setTchPwd(String tchPwd) {
        this.tchPwd = tchPwd;
    }

    public int getId() {
        return id;
    }

    public int getTchCla() {
        return tchCla;
    }

    public String getTchName() {
        return tchName;
    }

    public String getTchUser() {
        return tchUser;
    }

    public String getTchPwd() {
        return tchPwd;
    }
}
