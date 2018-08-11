package com.model;

public class StudentMark {
    private int id;
    private String name;
    private int english;
    private int math;
    private int chinese;
    private int java;
    private int sum;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public StudentMark()
    {

    }
    public StudentMark(int id, String name, int english, int math, int chinese, int java, int sum) {
        this.id = id;
        this.name = name;
        this.english = english;
        this.math = math;
        this.chinese = chinese;
        this.java = java;
        this.sum = sum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public int getEnglish() {
        return english;
    }

    public int getMath() {
        return math;
    }

    public int getChinese() {
        return chinese;
    }

    public int getJava() {
        return java;
    }

    public int getSum() {
        return sum;
    }

    public void sum()
    {
        this.sum = math + english +chinese +java;
    }
}
