package com.app;


import java.sql.SQLException;

import static com.app.AppUtil.*;

public class Login {
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
}

class Main {

    public void start() {
        while(true) {
            pntMain();
            int a = nextInt();
            switch (a) {
                case 1:
                    try {
                        new Manager().maneger();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        new Teacher().teacher(true);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                new Student().student();
                    break;
                case 4:
                    return;
            }
        }
    }

    public void pntMain()
    {
        pntTitle();
        pntlineInfo("1.管理员");
        pntlineInfo("");
        pntlineInfo("2.老师");
        pntlineInfo("");
        pntlineInfo("3.学生");
        pntlineInfo("");
        pntlineInfo("4.退出");
        pntEnd();
    }




}



