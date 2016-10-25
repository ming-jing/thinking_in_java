import java.util.ArrayList;
import java.util.List;

/**
 * Created by belows on 2016/10/24.
 */



public class Ex22 {

    interface Selector<T> {
        boolean end();
        void next();
        T current();
    }

    static class Sequence<T> {
        private List<T> ts;
        public Sequence() {
            ts = new ArrayList<T>();
        }

        public void add(T t) {
            ts.add(t);
        }

        public void clear() {
            ts.clear();
        }

        public Selector selector() {
            return new Selector<T>() {
                private int index = 0;
                @Override
                public boolean end() {
                    return index >= ts.size();
                }

                @Override
                public void next() {
                    ++index;
                }

                @Override
                public T current() {
                    return ts.get(index);
                }
            };
        }

        public Selector reverseSelector() {
            return new Selector<T>() {
                private int index = ts.size() -1;
                @Override
                public boolean end() {
                    return index < 0;
                }

                @Override
                public void next() {
                    --index;
                }

                @Override
                public T current() {
                    return ts.get(index);
                }
            };
        }
    }

    static void test(Selector<String> selector) {
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Sequence<String> ss = new Sequence<>();
        ss.add("I");
        ss.add("like");
        ss.add("you");

        test(ss.selector());
        test(ss.reverseSelector());

        ss.clear();
        test(ss.selector());
        test(ss.reverseSelector());
    }
}
