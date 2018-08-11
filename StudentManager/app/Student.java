package com.app;


import com.server.Server;
import com.sun.security.ntlm.NTLMException;

import java.sql.SQLException;

import static com.app.AppUtil.*;

public class Student {

    String user;
    Server server;

    public Student()
    {

        try {
            server = new Server();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void student(){
        while (true)
        {
            pntEnd();
            pntlineInfo("请输入账号");
            String user = nextLine();
            pntlineInfo("请输入密码");
            String pwd = nextLine();
            if(server.checkStuPwd(user, pwd))
            {
                this.user = user;
                break;
            }
            else
            System.out.println("账号密码不匹配");
        }

        while (true) {
            pntTitle();
            pntlineInfo("1.查看排名");
            pntlineInfo("2.修改密码");
            pntlineInfo("3.退出");
            pntEnd();
            switch (nextInt()) {
                case 1:
                    new Teacher().queryMark();
                    break;
                case 2:
                    change();
                    break;
                case 3:
                    return;
            }
        }
    }

    public void change() {
        pntTitle();
        pntlineInfo("请输入要修改的密码");
        String pwd = nextLine();
        server.change(3, pwd , new Integer(user));
    }

}
