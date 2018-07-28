package app.xupt;

import java.util.Iterator;

public class TestALinkedList {
    public static void main(String[] args) {
        ALinkList<String> a = new ALinkList<>();
        a.add("aaa");
        a.add("bb");
        a.add("cccc");
        a.add("ddddd");
        a.add(0, "zxc");
        a.set(1,"aa");
        a.delete(new String("bb"));
        Iterator<String> Ite = a.Iterator();
        while (Ite.hasNext())
        {
            System.out.println(Ite.next());
        }
        System.out.println("--------------");
        a.printf();


//        a.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });
//        a.stream().filter(s -> s.length() > 2).forEach(System.out::println);
    }
}
