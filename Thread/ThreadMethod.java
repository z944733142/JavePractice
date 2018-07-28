package app.xupt.Thread;

import static java.lang.Thread.*;

public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {

        justrun a1 = new justrun();
        justrun a2 = new justrun();
        Thread b1 = new Thread(a1);
        Thread b2 = new Thread(a2);
        b1.setName("This is a1");
        b2.setName("a2");
        System.out.println(b1.getName() + "  " + b2.getName());
        b1.setPriority(10);
        b2.setPriority(1);
        b1.start();
        b2.start();
        sleep(1000);
        a1.setA(false);
        a2.setA(false);



    }

}

class justrun implements java.lang.Runnable {

    boolean a = true;
    int i ;

    public void setA(boolean a) {
        this.a = a;
    }

    @Override

    public void run() {
        while (a)
        {
            System.out.println(Thread.currentThread().getName() +  "----" + i++);
        }
    }
}
