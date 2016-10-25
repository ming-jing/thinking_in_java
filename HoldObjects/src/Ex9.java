import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by belows on 2016/10/25.
 */


public class Ex9 {
    static class Sequence<T> {
        List<T> ts = new ArrayList<T>();
        public void add(T t) {
            ts.add(t);
        }

        public void clear() {
            ts.clear();
        }

        public Iterator<T> iterator() {
            return new Iterator<T>() {

                private int index = 0;
                @Override
                public boolean hasNext() {
                    return index<ts.size();
                }

                @Override
                public T next() {
                    return ts.get(index++);
                }
            };
        }
    }

    public static void main(String[]args) {
        Sequence<String> ss = new Sequence<String>();
        for (int i=0; i<10; ++i) {
            ss.add("Test Iterator " + i);
        }
        Iterator<String> is = ss.iterator();
        while (is.hasNext()) {
            System.out.println(is.next());
        }
    }
}
