import java.util.ArrayList;
import java.util.List;

/**
 * Created by belows on 2016/11/9.
 */
public class Ex4 {

    interface Selector<T> {
        boolean hasNext();
        T next();
    }

    static class Sequence<T> {
        List<T> data = new ArrayList<T>();

        public void add(T t) {
            data.add(t);
        }

        public Selector<T> selector() {
            return new Selector<T>() {
                int index = 0;
                @Override
                public boolean hasNext() {
                    return index < data.size();
                }

                @Override
                public T next() {
                    return data.get(index++);
                }
            };
        }
    }

    public static void main(String[] args) {
        Sequence<Integer> s = new Sequence<>();
        for (int i=0; i<10; ++i) {
            s.add(i);
        }
        Selector<Integer> selector = s.selector();
        while (selector.hasNext()) {
            System.out.print(selector.next() + " ");
        }
        System.out.println();
    }
}
