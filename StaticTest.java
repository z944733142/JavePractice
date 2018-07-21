package app.xupt;

public class StaticTest {
    public static void main(String[] args) {

//        Emoloyee a = new Emoloyee();
//        System.out.println(a.func());
//        System.out.println(a.func());             //      public int func ()
//        return id++;
        System.out.println(Emoloyee.func());
        System.out.println(Emoloyee.func());
    }
}

class Emoloyee {
    public  static int id = 1;
    public static int func (){
        return id++;
    }
}
