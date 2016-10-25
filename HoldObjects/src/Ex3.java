import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by belows on 2016/10/25.
 */

interface Selector<T> {
    boolean hasNext();
    T next();
    T remove();
}

class Sequence<T> {
    private List<T> ts = new ArrayList<T>();

    public Selector<T> selector() {
        return new Selector<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < ts.size();
            }

            @Override
            public T next() {
                return ts.get(index++);
            }

            @Override
            public T remove() {
                return ts.remove(index);
            }
        };
    }

    public Selector<T> reverseSelector() {
     return new Selector<T>() {
         private int index = ts.size()-1;
         @Override
         public boolean hasNext() {
             return index >= 0;
         }

         @Override
         public T next() {
             return ts.get(index--);
         }

         @Override
         public T remove() {
             return ts.remove(index);
         }
     };
    }

    public void add(T t) {
        ts.add(t);
    }
}

public class Ex3 {

    public static void main(String[] args) {
        Sequence<String> ss = new Sequence<>();
        for (int i=0; i<10; ++i) {
            ss.add("Test" + i);
        }
        
        Selector<String> s = ss.selector();
        while (s.hasNext()) {
            System.out.print(s.next());
        }
        System.out.println();
        s = ss.reverseSelector();
        while (s.hasNext()) {
            System.out.print(s.next());
        }
        System.out.println();
        s = ss.selector();
        while (s.hasNext()) {
            System.out.print(s.remove());
        }
        System.out.println();
        s = ss.reverseSelector();
        while (s.hasNext()) {
            System.out.print(s.remove());
        }
        System.out.println();


    }
}
