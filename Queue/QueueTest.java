package app.xupt.Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Quest> aQueue = new ArrayDeque<Quest>();
        for(int i = 0 ; i < 10 ; i++)
        {
            final int j = i;
            aQueue.offer(new Quest() {
                public void aQuest() {
                    System.out.println("号码 " + j + "存款： "+(Math.random() * 100));
                }
            });
        }
        Quest temp = null;
        for(int i = 0; i < 10 ; i++)
        {
            while((temp = aQueue.poll()) != null)
            {
                temp.aQuest();
            }
        }
    }
}

interface Quest
{
    public void aQuest ();
}

