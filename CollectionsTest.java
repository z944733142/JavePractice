package app.xupt.OtherTest;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {

        // shuffle 洗牌
        List<Integer> cards = new LinkedList<Integer>();
        for(int i = 0 ; i < 54 ; i++)
        {
            cards.add(i);
        }
        System.out.println(cards);
        Collections.shuffle(cards);
        System.out.println(cards);

//        // reverse 转置
//        List<Integer> cards = new LinkedList<Integer>();
//        cards.add(1);
//        cards.add(2);
//        cards.add(3);
//        cards.add(4);
//        System.out.println(cards);
//        java.util.Collections.reverse(cards);
//        System.out.println(cards);





//        // binarySearch 二分查找
//        // 需提前排序
//        List<Integer> cards = new LinkedList<Integer>();
//        for(int i = 30 ; i < 100 ; i += 2)
//        {
//            cards.add(i);
//        }
//        System.out.println(cards);
//        System.out.println("46index: " + Collections.binarySearch(cards,46));
//        System.out.println("20index: " + Collections.binarySearch(cards,20));



//        // swap 交换
//        List<Integer> cards = new LinkedList<Integer>();
//        for(int i = 0 ; i < 10 ; i++)
//        {
//            cards.add(i);
//        }
//
//        System.out.println(cards);
//        Collections.swap(cards,1,8);
//        System.out.println(cards);


    }
}
