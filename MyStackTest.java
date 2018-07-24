package app.xupt.Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStackTest
{
    public static void main(String[] args) {

        MyStack<String> aStack = new MyStack<String>(2);
        aStack.add("123");
        aStack.add("234");
        aStack.add("8888");
        System.out.println(aStack.get());
        System.out.println(aStack.get());
        System.out.println(aStack.get());

    }
}

class MyStack<T>
{
    Queue<T> stack = new ArrayDeque<T>();

    int cap;

    public MyStack(int cap) {
        this.cap = cap;
    }

    public boolean add(T t)
    {
        if( stack.size() + 1 > cap)
        {
            return false;
        }
        return stack.offer(t);
    }

    public T get()
    {
        return stack.poll();

    }

}