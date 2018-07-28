package app.xupt.Thread;

import static java.lang.Thread.sleep;

public class StopThread {
    public static void main(String[] args) throws InterruptedException {
        run a = new run();
        Thread b = new Thread(a);

        b.start();
        sleep(1001);

        a.key = false;

    }
}

class run implements java.lang.Runnable {
    boolean  key = true;
    int i = 0;

    @Override
    public void run() {

    while(key)
    {
        try {
            sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i++ + "步");
    }
    }


}