package app.xupt;


import java.util.*;


public class MapTest {    // 迭代Map
    public static void main(String[] args) {
        Map <String,String>a = new HashMap<String, String>();
        a.put("aaa","bbb");
        a.put(new String("aaa"),"ccc");
        Set <Map.Entry<String,String>> b = a.entrySet();
        Iterator<Map.Entry<String,String>> c = b.iterator();
       while(c.hasNext()){
            Map.Entry<String,String> temp = c.next();
            String str = temp.getKey();
           System.out.println(str + temp.getValue());
        }

    }
}


