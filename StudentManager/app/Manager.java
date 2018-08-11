package com.app;


import com.model.TeacherInfo;

import com.server.Server;


import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;

import static com.app.AppUtil.*;

public class Manager {

    Server server = null;

    public Manager() {
        try {
            server = new Server();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void maneger() throws SQLException {

        while (true) {
            pntlineInfo("请输入账号");
            String user = nextLine();
            pntlineInfo("请输入密码");
            String pwd = nextLine();
            if (server.checkMngPwd(user, pwd))
            {
                break;
            }
            else {
                pntlineInfo("账号密码不匹配,重新输入");
            }
        }
        while (true) {
            pntTitle();
            pntlineInfo("1.管理学生");
            pntlineInfo("2.管理老师");
            pntlineInfo("3.退出");
            pntEnd();
            int a = nextInt();
            switch (a) {
                case 1:
                    try {
                        new Teacher().teacher(false);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    manage();
                    break;
                case 3:
                    return;
            }
        }
    }

    private void manage() {
        while (true) {
            pntTitle();
            pntlineInfo("1.老师目录");
            pntlineInfo("2.增加老师");
            pntlineInfo("3.删除老师");
            pntlineInfo("4.修改老师密码");
            pntlineInfo("5.退出");
            pntEnd();
            switch (nextInt()) {
                case 1:
                    teaList();
                    break;
                case 2:
                    addTea();
                    break;
                case 3:
                    deleteTch();
                    break;
                case 4:
                    changeTea();
                    break;
                case 5:
                    return;
            }
        }
    }

    private void teaList() {
        HashSet aSet = server.pntTtcInfo();
        Iterator ite = aSet.iterator();
        pntTitle();
        pntlineInfo(10, "工号    姓名             班级    账号              密码 ");
        while (ite.hasNext()) {
            pntlineInfo(10, new String((StringBuilder) ite.next()));
        }
        nextLine();
    }

    private void changeTea ()
    {
        pntTitle();
        pntlineInfo("请输出要修改的老师账号");
        String User = nextLine();
        if(!server.checkId(new Integer(User)))
        {
            pntlineInfo("请输入修改的密码");
            String Pwd = nextLine();
            server.change(2, Pwd, new Integer(User));
        }
        else
            pntlineInfo("账号不存在");
    }

    private void addTea() {
        HashSet<TeacherInfo> hashSet = new HashSet<>();
        while (true) {
            pntTitle();
            pntlineInfo("请输入工号(输入负数退出录入)");
            Integer id = 0;
            boolean flag;
            while (true) {
                flag = false;
                id = nextInt();
                Iterator<TeacherInfo> ite = hashSet.iterator();
                while (ite.hasNext()) {
                    if ((ite.next().getId() == id))
                        flag = true;
                }
                if (server.checkId(id) && !flag) {
                    break;
                } else pntlineInfo("输入错误重新输入(输入负数退出录入)");
            }
            if (id < 0)
                break;
            pntlineInfo("请输入姓名");
            String name = nextLine();
            pntlineInfo("请输入管理的班级");
            int clas = nextInt();
            hashSet.add(new TeacherInfo(id, clas, name, id.toString(), id.toString()));
        }
        if (server.addThcInfo(hashSet)) {
            pntlineInfo("成功添加" + hashSet.size() + "名老师");
            nextLine();
        } else {
            pntlineInfo("添加失败");
        }
    }

    private void deleteTch ()
    {
        pntTitle();
        while (true) {
            pntlineInfo("请输入id(输入负数退出)");
            int id = nextInt();
            if (id < 0) {
                break;
            }
            try {
                server.delete(id);
                pntlineInfo("删除成功");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
