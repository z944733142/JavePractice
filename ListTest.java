import java.util.*;

public class ListTest {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("aaa");
        list.add(new Date());
        Map a = new HashMap();
        list.remove(new Date());
        System.out.println(list.size());


    }
}
