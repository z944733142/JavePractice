package com.server;

import com.dao.MysqlGet;
import com.dao.MysqlSet;
import com.model.StudentInfo;
import com.model.StudentMark;
import com.model.TeacherInfo;

import java.sql.SQLException;
import java.util.*;


public class Server {
    HashSet<StudentInfo> stuInfoSet = null;
    HashSet<StudentMark> stuMarkSet = null;
    HashSet<TeacherInfo> teaInfoSet = null;
    MysqlGet get = null;
    MysqlSet set = null;
    public Server () throws SQLException {
        get = new MysqlGet();
        set = new MysqlSet();
        stuInfoSet = get.getStudentInfoSet();
        stuMarkSet = get.getStudentMark();
        teaInfoSet = get.getTeacherInfo();
    }

    public boolean checkStuPwd(String user, String pwd)
    {
        Iterator ite = stuInfoSet.iterator();
        while(ite.hasNext())
        {
            StudentInfo SI = (StudentInfo) ite.next();
            if(SI.getStuUser().equals(user) && SI.getStuPwd().equals(pwd))
            {
                return true;
            }
        }
        return false;
    }
    public boolean checkMngPwd(String user, String pwd)
    {
       return get.checkMng(user, pwd);

    }
    public HashSet<StringBuilder> pntStuInfo (int id)
    {
        int cla = 0;
        Iterator ite = teaInfoSet.iterator();
        while (ite.hasNext())
        {
            TeacherInfo TI = (TeacherInfo) ite.next();
            if(((Integer)TI.getId()).equals(id) )
            {
                cla = TI.getTchCla();
                break;
            }
        }
        
        HashSet<StringBuilder> hashSet = new HashSet<>();
       ite = stuInfoSet.iterator();
        while (ite.hasNext())
        {
            StudentInfo aInfo = (StudentInfo) ite.next();
            StringBuilder Info = new StringBuilder();
            if(((Integer)aInfo.getStuCla()).equals(cla) || cla == 0) {
                Info.append(aInfo.getStuName() + " " + blank(10, aInfo.getStuName().length() * 2));
                Info.append(aInfo.getStuId() + " " + blank(10, ((Integer) aInfo.getStuId()).toString().length()));
                Info.append(aInfo.getStuCla() + " " + blank(6, ((Integer) aInfo.getStuCla()).toString().length()));
                Info.append(aInfo.getStuUser() + " " + blank(16, aInfo.getStuUser().length()));
                Info.append(aInfo.getStuPwd() + " " + blank(16, aInfo.getStuPwd().length()));
                hashSet.add(Info);
            }
        }

        return hashSet;
    }

    public static StringBuilder blank (int i1, int i2)
    {
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < i1 -i2; i++){
            temp.append(" ");
        }
        return temp;
    }
    public HashSet<StringBuilder> pntStuMark ()
    {
        HashSet<StringBuilder> hashSet = new HashSet<>();
        Iterator<StudentMark> ite = stuMarkSet.iterator();
        while (ite.hasNext())
        {
            StudentMark aInfo = ite.next();
            StringBuilder Info = null;
            Info.append(aInfo.getEnglish() + "  ");
            Info.append(aInfo.getMath() + "  ");
            Info.append(aInfo.getChinese() + "  ");
            Info.append(aInfo.getJava() + "  ");
            Info.append(aInfo.getSum());
            hashSet.add(Info);
        }

        return hashSet;
    }


    public String checStukId(int id)
    {
        Iterator<StudentInfo> ite = stuInfoSet .iterator();
        while (ite.hasNext())
        {
            StudentInfo SM = ite.next();
            if(SM.getStuId() == id)
                return SM.getStuName();
        }
        return "";
    }

    public boolean addstuInfo(HashSet<StudentInfo> hashSet)
    {
        try {
            set.setStudentInfo(hashSet);
            this.stuInfoSet.addAll(hashSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void change(int key, String Pwd, int id)
    {
        try {
            set.updatePwd(key, Pwd, id);
            teaInfoSet = get.getTeacherInfo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteStu(int id) throws SQLException {
        Iterator<StudentInfo> ite = stuInfoSet.iterator();
        while (ite.hasNext())
        {
            if(ite.next().getStuId() == id ) {
                ite.remove();
                set.deleteStu(id);
            }


        }
        return true;
    }

    public void addstuMark(HashSet<StudentMark> hashSet)
    {
        try {
            set.setStudentMark(hashSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        stuMarkSet.addAll(hashSet);
    }

    public ArrayList query(int i)
    {
        ArrayList alist = new ArrayList();
        Iterator ite = stuMarkSet.iterator();
        while(ite.hasNext())
        {
            alist.add(ite.next());
        }
        switch (i){
            case 1:
                Collections.sort(alist,new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return -((Integer)((StudentMark)o1).getSum()).compareTo(((StudentMark)o2).getSum());
                    }
                });
                break;
            case 2:
                Collections.sort(alist,new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return -((Integer)((StudentMark)o1).getEnglish()).compareTo(((StudentMark)o2).getEnglish());
                    }
                });
                break;
            case 3:
                Collections.sort(alist,new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return -((Integer)((StudentMark)o1).getMath()).compareTo(((StudentMark)o2).getMath());
                    }
                });
                break;
            case 4:
                Collections.sort(alist,new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return -((Integer)((StudentMark)o1).getChinese()).compareTo(((StudentMark)o2).getChinese());
                    }
                });
                break;
            case 5:
                Collections.sort(alist,new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return -((Integer)((StudentMark)o1).getJava()).compareTo(((StudentMark)o2).getJava());
                    }
                });
                break;
        }

        ArrayList list = new ArrayList();
        ite = alist.iterator();
        while (ite.hasNext())
        {
            StudentMark SM = (StudentMark)ite.next();
            StringBuilder Info = new StringBuilder();
            Info.append(SM.getId() + " " + blank(6, ((Integer)SM.getId()).toString().length()));
            Info.append(SM.getName() + " " + blank(16, SM.getName().length() * 2));
            Info.append(SM.getEnglish() +" "+ blank(6, ((Integer)SM.getEnglish()).toString().length()));
            Info.append(SM.getMath() + " " + blank(6, ((Integer)SM.getMath()).toString().length()));
            Info.append(SM.getChinese() + " " + blank(6, ((Integer)SM.getChinese()).toString().length()));
            Info.append(SM.getJava() + " " + blank(6, ((Integer)SM.getJava()).toString().length()));
            Info.append(SM.getSum() + " " + blank(6, ((Integer)SM.getSum()).toString().length()));
            list.add(Info);
        }
        return list;
    }

    public HashSet<StringBuilder> pntTtcInfo ()
    {
        HashSet<StringBuilder> hashSet = new HashSet<>();
        Iterator<TeacherInfo> ite = teaInfoSet .iterator();
        while (ite.hasNext())
        {
            TeacherInfo aInfo = ite.next();
            StringBuilder Info = new StringBuilder();
            Info.append(aInfo.getId() + "  " + blank(6, ((Integer)aInfo.getId()).toString().length()));
            Info.append(aInfo.getTchName() + "  " + blank(16, aInfo.getTchName().length() * 2));
            Info.append(aInfo.getTchCla() + " " + blank(6, ((Integer)aInfo.getTchCla()).toString().length()));
            Info.append(aInfo.getTchUser() + "  " + blank(16, aInfo.getTchUser().length()));
            Info.append(aInfo.getTchPwd());
            hashSet.add(Info);
        }

        return hashSet;
    }

    public boolean addThcInfo(HashSet<TeacherInfo> hashSet)
    {
        try {
            set.setTeacherInfo(hashSet);
            this.teaInfoSet.addAll(hashSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean checkId(int id)
    {
        Iterator<TeacherInfo> ite = teaInfoSet .iterator();
        while (ite.hasNext())
        {
            TeacherInfo SM = ite.next();
            if(SM.getId() == id)
                return false;
        }
        return true;
    }

    public boolean delete(int id) throws SQLException {
        Iterator<TeacherInfo> ite = teaInfoSet.iterator();
        while (ite.hasNext())
        {
            if(ite.next().getId() == id ) {
                ite.remove();
                set.deleteThc(id);
                set.deleteStumark(id);
            }

        }
        return true;
    }

    public boolean checkPwd(String User, String Pwd)
    {
        Iterator<TeacherInfo> ite = teaInfoSet.iterator();
        while (ite.hasNext())
        {
            TeacherInfo TI =  ite.next();
            if(TI.getTchUser().equals(User) && TI.getTchPwd().equals(Pwd))
            {
                return true;
            }

        }
        return false;
    }
}
