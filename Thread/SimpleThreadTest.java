package app.xupt.Thread;

import static java.lang.Thread.sleep;

public class SimpleThreadTest {

    public static void main(String[] args) {
        a A = new a();
        b B = new b();
        A.start();
        B.start();

        for(int i = 0 ;i < 1000; i++)
        {            try {
            sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            System.out.println("main is running " + i);
        }
    }
}


class a extends Thread {
    @Override
    public void run() {
        for(int i = 0 ;i < 1000; i++)
        {
            try {
                sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("a is running " + i);
        }
    }
}

class  b extends Thread {
    @Override
    public void run() {
        for(int i = 0 ;i < 1000; i++)
        {
            try {
                sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b is running " + i);
        }
    }
}
