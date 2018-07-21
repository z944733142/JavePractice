package app.xupt;

public class MethosTest {
    public static void main(String[] args) {
        test a = new test();
        int b = a.add(a.a(),a.a());
        System.out.println(b);
    }
}

class test {
    int c                                                  ;
    public  int add (int a, int b)
    {
        return a + b;
    }
    public  int a ()
    {
        return c++;
    }
}
