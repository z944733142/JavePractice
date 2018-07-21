package app.xupt;

class Person <T1, T2>
{
    private T1 name;
    private T2 age;

    public T1 getName() {
        return this.name;
    }

    public T2 getAge() {
        return age;
    }

    public void setName(T1 name) {
        this.name = name;
    }

    public void setAge(T2 age) {
        this.age = age;
    }

    public void fun1 (T1 a) {
        System.out.println(" " + name + age + a);
    }
}
/*
    extends  子类 >= 父类
 */


/*
    1. 父类擦除 子类 >= 父类
 */
class Student<T1> extends Person {
    private T1 number;
    @Override
    public void fun1(Object a) {
        super.fun1(a);
    }
}


class Student2<T1, T2> extends Person <T1, T2> {
    private T1 number;

    public Student2(T1 number, T1 name, T2 age) {
        this.number = number;
        super.setAge(age);
        super.setName(name);
    }

    public T1 getNumber() {
        return number;
    }

    @Override
    public void fun1(T1 a) {
        super.fun1(a);
    }
}

/*
    属性类型
        子类中随子类，父类中随父类
    方法重写
        随父类
 */

class Student3 <T1, T2, T3> extends Person<T1, T2> {
    private T3 number;
    private T1 classes;
    @Override
    public void fun1(T1 a) {
        super.fun1(a);
    }

}
public class GenTest {
    public static void main(String[] args) {
        Person <String, Integer> one = new<String, Integer> Student2("123","zs","15");
        System.out.println(one.getAge() + one.getName() + ((Student2<String, Integer>) one).getNumber());
    }
}


