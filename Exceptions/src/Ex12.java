/**
 * Created by belows on 2016/11/1.
 */

interface Selector<T> {
    boolean hasNext();
    T next();
}

class Sequence<T> {

    Object[] emlements = null;
    int index = 0;

    Sequence(int size) {
        emlements = new Object[size];
    }

    public void add(T t) {
        if (index < emlements.length) {
            emlements[index++] = t;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    Selector<T> selector() {
        return new Selector<T>() {

            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < Sequence.this.index;
            }

            @Override
            public T next() {
                return (T)emlements[index++];
            }
        };
    }
}
public class Ex12 {
    public static void main(String[] args) {
        Sequence<String> s = new Sequence<>(5);
        for (int i=0; i<10; ++i) {
            s.add("Test" + i);
        }
        Selector<String> selector = s.selector();
        while (selector.hasNext()) {
            String ss = selector.next();
            System.out.println(ss);
        }
    }
}
