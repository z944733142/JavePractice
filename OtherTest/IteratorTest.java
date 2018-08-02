package app.xupt.OtherTest;

import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {
        /*Set
        Set<Double> a = new HashSet<>();
        a.add(159.159);
        a.add(159.159);
        a.add(3.1415926);
        System.out.println(a.size());
        for(Iterator b = a.iterator(); b.hasNext();)
        {
            System.out.println(b.next());
        }
        */

        /*List
        List<Integer> a = new ArrayList<>();
        a.add(100);
        a.add(100);
        a.add(200);
        System.out.println(a.size());
        Iterator b = a.iterator();
        while(b.hasNext())
        {
            System.out.println(b.next());
        }
        */

        Map<String, String> a = new HashMap<String, String>();
        a.put("aaa", "bbb");
        a.put(new String("aaa"), "ccc");
        Set<Map.Entry<String, String>> b = a.entrySet();
        Iterator<Map.Entry<String, String>> c = b.iterator();
        while (c.hasNext()) {
            Map.Entry<String, String> temp = c.next();
            String str = temp.getKey();
            System.out.println(str + temp.getValue());
        }

    }
}
