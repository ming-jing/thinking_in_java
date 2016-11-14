import java.util.Iterator;

/**
 * Created by belows on 2016/11/10.
 */
public class Ex7 {
    static class IterableFibonacci extends Fibonacci implements Iterable<Integer> {

        private int count;

        IterableFibonacci(int count) {
            this.count = count;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {

                int n = count;

                @Override
                public boolean hasNext() {
                    return n>0;
                }

                @Override
                public Integer next() {
                    n--;
                    return IterableFibonacci.this.next();
                }
            };
        }
    }

    static class CompositionFibonacci implements Iterable<Integer>{

        Fibonacci fib = new Fibonacci();
        int count;

        CompositionFibonacci(int count) {
            this.count = count;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {

                int n = count;

                @Override
                public boolean hasNext() {
                    return n > 0;
                }

                @Override
                public Integer next() {
                    n--;
                    return fib.next2();
                }
            };
        }
    }

    public static void main(String[] args) {
        IterableFibonacci fib = new IterableFibonacci(18);
        for (int i : fib) {
            System.out.print(i + " ");
        }
        System.out.println();

        CompositionFibonacci f = new CompositionFibonacci(18);
        for (int i : f) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
