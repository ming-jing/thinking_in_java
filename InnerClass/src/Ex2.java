/**
 * Created by belows on 2016/10/19.
 */

interface Selector {
    boolean end();
    void next();
    Object current();
}

class Sequence {
    private Object[] mItems;
    private int current = 0;

    public Sequence(int size) {
        mItems = new Object[size];
    }

    public void add(Object o) {
        mItems[current++] = o;
    }

    public Selector selector() {
     return new Selector() {
         int index = 0;
         @Override
         public boolean end() {
             return index >= mItems.length;
         }

         @Override
         public void next() {
             ++index;
         }

         @Override
         public Object current() {
             return mItems[index];
         }

         public Sequence outer() {
             return Sequence.this;
         }
     };
    }
}

class T2 {
    String s;
    T2(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}

public class Ex2 {

    public static void main(String[] args) {
        Sequence s = new Sequence(10);
        for (int i=0; i<10; ++i) {
            s.add(new T2("test" + i));
        }
        Selector selector = s.selector();
        while (!selector.end()) {
            Object o = selector.current();
            System.out.println(selector.current());
            selector.next();
        }
    }

}
