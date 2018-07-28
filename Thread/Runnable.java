package app.xupt.Thread;

import static java.lang.Thread.sleep;

public class Runnable {
    public static void main(String[] args) {
        w12306 a = new w12306();
        Thread a1 = new Thread(a,"a1");
        Thread a2 = new Thread(a,"a2");
        Thread a3 = new Thread(a,"a3");
        a1.start();
        a2.start();
        a3.start();

    }
}

class w12306 implements java.lang.Runnable {
    int p = 1000;
    @Override
    public void run() {
        while (true)
        {
            if(p > 0)
            {

                System.out.println(Thread.currentThread().getName() + "抢到了" + p--);
            }
            else break;
        }
    }
}
