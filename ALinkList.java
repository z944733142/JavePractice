package app.xupt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ALinkList<T> {
    private Node head;
    private Node last;
    private int size;

    public int getSize() {
        return size;
    }

    public Node getLast() {
        return last;
    }

    public Node getHead() {
        return head;
    }

    public Iterator<T> Iterator ()
    {
        Iterator<T> Ite = new Iterator<T>() {
            Node<T> current = head.next;
            Node<T> temp = current;
            public boolean hasNext() {
                if(current != null)
                {
                    return true;
                }
                return false;
            }

            @Override
            public T next()
            {
                if(current != null)
                {
                    temp = current;
                    current = current.next;
                    return temp.item;
                }
                return null;
            }
        };
        return Ite;
    }

    private void ensureIndex (int index)
    {
        if (index > size || index < 0)
        {
            throw new IndexOutOfBoundsException("out of index");
        }
    }
    public void printf () {
        Node current = head.next;
        while(current != null)
        {
            System.out.println(current.item);
            current = current.next;
        }
    }

    public void set(int index, T item)
    {
        ensureIndex (index);
        Node current = head.next;
        while(index-- != 0)
        {
            current = current.next;
        }
        current.item = item;
    }

    public void add(int index, T item)
    {
        ensureIndex (index);
        Node current = head.next;
        while(index-- != 0)
        {
            current = current.next;
        }
        Node<T> node = new Node<T>();
        node.next = current;
        node.prev = current.prev;
        node.item = item;
        current.prev.next = node;
        current.prev = node;
        size++;

    }

    public void delete(T a)
    {
        Node current = head.next;
        Node temp;
        while ( current != null)
        {
            if(current.item.equals(a))
            {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                return;
            }
            current = current.next;
        }
    }

    public ALinkList() {

        Node<T> a = new Node();
        this.head = a;
        this.last = a;
        a.prev = null;
        a.next = null;
        size = 0;
    }

    public void add (T a)
    {
        Node <T> node = new Node<T>();

        if(0 == size)
        {
            head.next = node;
        }
        last.next = node;
        node.next = null;
        node.prev = last;
        node.item = a;
        last = node;
        size ++;
    }
}

class Node <T>{
    Node prev;
    Node next;
    T item;

    public Node(){

    }
    public Node(Node prev, Node next, T item) {
        this.prev = prev;
        this.next = next;
        this.item = item;
    }
}

