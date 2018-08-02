package app.xupt.OtherTest;

public class ExtendsDemo extends father{
    public static void main(String[] args) {

    new ExtendsDemo().func();
    }
}





class father extends superfather{

    public void func (){
        System.out.println(1);
    }
}

class superfather {

    public void func ()
    {
        System.out.println(2);
    }
        }