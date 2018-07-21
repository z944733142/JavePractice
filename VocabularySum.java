package app.xupt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class VocabularySum {
    public static void main(String[] args) {
        String str = "hello world ! Thinking in Java , Core Java Volume I-Fundamentals Java in";
        String[] strArray = str.split(" ");
        Map<String,Integer> map = new HashMap<>();
        int temp2;
        for (String St: strArray)
        {
            if(map.containsKey(St))
            {
                temp2 = map.get(St)+1;
                map.put(St, temp2);
            }
            else map.put(St,1);
        }
        Set<Map.Entry<String,Integer>> d = map.entrySet();
        Iterator<Map.Entry<String,Integer>> Ite = ((Set) d).iterator();
        while(Ite.hasNext())
        {
            Map.Entry<String, Integer> temp = Ite.next();
            System.out.println(temp.getKey() + " " + temp.getValue());
        }
    }

}
