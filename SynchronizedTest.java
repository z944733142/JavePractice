package app.xupt.Thread;

import static java.lang.Thread.*;

public class SynchronizedTest {
    public static void main(String[] args) {

        www12306 a = new www12306();
        Thread a1 = new Thread(a, "a1");
        Thread a2 = new Thread(a, "a2");
        Thread a3 = new Thread(a, "a3");
        a1.start();
        a2.start();
        a3.start();
    }
}

class www12306 implements java.lang.Runnable {
    int p = 5;

    public void run3() {
        synchronized (this) {

            while (true) {
                if (p > 0) {
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "抢到了" + p--);
                } else break;
            }
        }
    }

        public synchronized void run2 ()
        {
            while (true) {
                if (p > 0) {
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "抢到了" + p--);
                } else break;
            }

        }


        public void run () {
//           run2();
            run3();
        }
    }