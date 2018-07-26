package app.xupt.Thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Thread.sleep;

public class Sleep {
    public static void main(String[] args) throws InterruptedException {
        Date current = new Date();
        int i = 0;
        while(true)
        {
            DateFormat format = new SimpleDateFormat("mm:ss");
            System.out.println(format.format(current));
            sleep(1000);
            current = new Date(current.getTime() + 1000);
            if(i++ == 10)
                break;

        }
    }
}
