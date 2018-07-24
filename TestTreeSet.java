package app.xupt.Tree;

import java.util.Comparator;
import java.util.TreeSet;

class Employee {
    private String name;
    private int age;
    private long id;

    public Employee(String name, int age, long id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.id + "\n" ;
    }
}
public class TestTreeSet {
    public static void main(String[] args) {
    Employee a1 = new Employee("a1", 18, 4171001);
    Employee a2 = new Employee("a2", 28, 4171011);
    Employee a3 = new Employee("a3", 19, 4171011);
    Employee a4 = new Employee("a4", 13, 4171001);
    Employee a5 = new Employee("a5", 26, 4171002);
    Employee a6 = new Employee("a6", 18, 4171004);
    Employee a7 = new Employee("a7", 19, 4171008);

        TreeSet<Employee> a = new TreeSet<Employee>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(o1.getId() > o2.getId()) return 1;
                else if (o1.getAge() > o2.getAge()) return 1;
                else return -1;
            }
        });

        a.add(a6);
        a.add(a7);
        a.add(a4);
        a.add(a5);
        a.add(a3);
        a.add(a2);
        a.add(a1);



        System.out.println(a);


    }
}
