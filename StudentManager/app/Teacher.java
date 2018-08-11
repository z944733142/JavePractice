package com.app;

import com.model.StudentInfo;
import com.model.StudentMark;
import com.server.Server;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import static com.app.AppUtil.*;
import static com.app.AppUtil.nextLine;

public class Teacher {
    Server server = null;
    int id ;
    boolean key;
    static int cla;
    private String tchUser;
    private String tchPwd;

    public Teacher() {
        try {
            server = new Server();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void teacher(boolean key) throws SQLException {
        pntTitle();
        this.key = key;
        if (key) {
            while (true) {
                pntlineInfo("请输入账号");
                String user = nextLine();
                pntlineInfo("请输入密码");
                String pwd = nextLine();
                if (server.checkPwd(user, pwd))
                {
                    this.tchPwd = pwd;
                    this.tchUser = user;
                    this.id = new Integer(user);
                    break;
                }
                else {
                    pntlineInfo("账号密码不匹配,重新输入");
                }
            }
        }
        while (true) {
            pntTitle();
            pntlineInfo("1.学生目录");
            pntlineInfo("2.添加学生");
            pntlineInfo("3.删除学生");
            pntlineInfo("4.录入成绩");
            pntlineInfo("5.成绩排名");
            pntlineInfo("6.修改密码");
            pntlineInfo("7.退出");
            pntEnd();
            int a = nextInt();
            switch (a) {
                case 1:
                    pntList();
                    break;
                case 2:
                    addStu();
                    break;
                case 3:
                    deleteStu();
                    break;
                case 4:
                    addMark();
                    break;
                case 5:
                    queryMark();
                    break;
                case 6:
                    change();
                case 7:
                    return;
            }
        }
    }

    private void change()
    {
        if(id > 0)
        {
            pntTitle();
            pntlineInfo("你的账号");
            pntlineInfo("" +this.id);
            pntlineInfo("请输入修改的密码");
            String Pwd = nextLine();
            server.change(2, Pwd, id);
        }
        else if(id == 0)
        {
            pntTitle();
            pntlineInfo("请输出要修改的学生账号");
            String User = nextLine();
            if(server.checStukId(new Integer(User)) != "")
            {
                pntlineInfo("请输入修改的密码");
                String Pwd = nextLine();
                server.change(3, Pwd, new Integer(User));
            }
            else
                pntlineInfo("账号不存在");
        }
    }
    private void pntList() {
        HashSet aSet = this.server.pntStuInfo(this.id);
        java.util.Iterator ite = aSet.iterator();
        pntTitle();
        pntlineInfo(10, "姓名       学号      班级    账号             密码");
        while (ite.hasNext()) {
            pntlineInfo(10, new String((StringBuilder) ite.next()));
        }
        pntEnd();
        nextLine();
    }

    private void addStu() {
        HashSet<StudentInfo> hashSet = new HashSet<>();
        while (true) {
            pntTitle();
            pntlineInfo("请输入学号(输入负数退出录入)");
            Integer id = 0;
            boolean flag;
            while (true) {
                flag = false;
                id = nextInt();
                Iterator<StudentInfo> ite = hashSet.iterator();
                while (ite.hasNext()) {
                    if ((ite.next().getStuId() == id))
                        flag = true;
                }
                if (server.checStukId(id) == "" && !flag) {
                    break;
                } else pntlineInfo("输入错误重新输入(输入负数退出录入)");
            }
            if (id < 0)
                break;
            pntlineInfo("请输入姓名");
            String name = nextLine();
            pntlineInfo("请输入班级");
            int clas = nextInt();
            hashSet.add(new StudentInfo(id, clas, name, id.toString(), id.toString()));
        }
        if (server.addstuInfo(hashSet)) {
            pntlineInfo("成功添加" + hashSet.size() + "名学生");
        } else {
            pntlineInfo("添加失败");
        }
    }

    private void deleteStu() {
        pntTitle();
        while (true) {

            pntlineInfo("请输入id(输入负数退出)");
            int id = nextInt();
            if (id < 0) {
                break;
            }
            try {
                server.deleteStu(id);
                pntlineInfo("删除成功");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void addMark() {
        HashSet<StudentMark> hashSet = new HashSet<>();
        boolean flag = false;
        while (true) {
            int id;
            String name = null;
            pntlineInfo("请输入id(输入负数退出)");
            while (true) {
                id = nextInt();
                if (id < 0) {
                    flag = true;
                    break;
                } else flag = false;
                if ((name = server.checStukId(id)) != "")
                    break;
                else {
                    pntlineInfo("id不存在,请重新输入(输入负数退出)");
                }
            }
            if (flag)
                break;
            pntlineInfo("请输入英语成绩");
            int english = nextInt();
            pntlineInfo("请输入数学成绩");
            int math = nextInt();
            pntlineInfo("请输入语文成绩");
            int chinese = nextInt();
            pntlineInfo("请输入java成绩");
            int java = nextInt();
            int sum = english + math + chinese + java;
            hashSet.add(new StudentMark(id, name, english, math, chinese, java, sum));
        }
        server.addstuMark(hashSet);
    }

    public void queryMark() {
        while (true) {

            List aList = new ArrayList();
            pntTitle();
            pntlineInfo("1.总分排名");
            pntlineInfo("2.语文排名");
            pntlineInfo("3.数学排名");
            pntlineInfo("4,英语排名");
            pntlineInfo("5.java排名");
            pntlineInfo("6.退出");
            pntEnd();
            switch (nextInt()) {
                case 1:
                    aList = server.query(1);
                    break;
                case 2:
                    aList = server.query(2);
                    break;
                case 3:
                    aList = server.query(3);
                    break;
                case 4:
                    aList = server.query(4);
                    break;
                case 5:
                    aList = server.query(5);
                    break;
                case 6:
                    return;
            }
            pntTitle();
            pntlineInfo(10, "id     姓名            语文   数学   英语   java   总分");
            Iterator ite = aList.iterator();
            while (ite.hasNext()) {
                pntlineInfo(10, ite.next().toString());
            }
            pntEnd();
            nextLine();

        }
    }

}



