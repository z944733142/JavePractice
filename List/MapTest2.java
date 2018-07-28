package app.xupt;

import javax.swing.text.html.HTMLDocument;
import java.util.*;


/*
    学生成绩统计 Map练习
 */
class Studenta {
    private String name;
    private String classNumber;
    private int score;

    public String getName() {
        return name;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Studenta(String name, String classNumber, int score) {
        this.name = name;
        this.classNumber = classNumber;
        this.score = score;
    }
}
public class MapTest2 {
    public static void main(String[] args) {
    Studenta a1 = new Studenta("张三","1",85);
    Studenta a2 = new Studenta("张四","2",85);
    Studenta a3 = new Studenta("张五","1",74);
    Studenta a4 = new Studenta("张三2","2",45);
    Studenta a5 = new Studenta("张三3","2",81);
    Studenta a6 = new Studenta("张三4","1",75);
    Studenta a7 = new Studenta("张三5","1",35);

    Studenta a[] = {a1, a2, a3, a4, a5, a6, a7};

    int temp;
    Map<String, Integer> hMap = new HashMap<String, Integer>();
        for (int i = 0; i < a.length; i++) {
            if(hMap.containsKey(a[i].getClassNumber()))
            {
                temp = hMap.get(a[i].getClassNumber());
                hMap.put(a[i].getClassNumber(), temp + a[i].getScore());
            }
            else {
                hMap.put(a[i].getClassNumber(), a[i].getScore());
            }
        }

        Set<Map.Entry<String, Integer>> Ent = hMap.entrySet();
        Iterator<Map.Entry<String, Integer>> ite = Ent.iterator();
        while(ite.hasNext())
        {
            Map.Entry<String, Integer> temp2 =ite.next();
            System.out.println(temp2.getKey() + " " + temp2.getValue());
        }

    }



}
