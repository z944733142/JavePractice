package app.xupt.OtherTest;

import java.util.Collection;
import java.util.Iterator;

public class InterfaceDemo {

  Collection a = new Collection() {
      @Override
      public int size() {
          return 0;
      }

      @Override
      public boolean isEmpty() {
          return false;
      }

      @Override
      public boolean contains(Object o) {
          return false;
      }

      @Override
      public Iterator iterator() {
          return null;
      }

      @Override
      public Object[] toArray() {
          return new Object[0];
      }

      @Override
      public Object[] toArray(Object[] a) {
          return new Object[0];
      }

      @Override
      public boolean add(Object o) {
          return false;
      }

      @Override
      public boolean remove(Object o) {
          return false;
      }

      @Override
      public boolean containsAll(Collection c) {
          return false;
      }

      @Override
      public boolean addAll(Collection c) {
          return false;
      }

      @Override
      public boolean removeAll(Collection c) {
          return false;
      }

      @Override
      public boolean retainAll(Collection c) {
          return false;
      }

      @Override
      public void clear() {

      }
  };



}
