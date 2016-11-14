/**
 * Created by belows on 2016/11/9.
 */
public class Fibonacci implements Generator<Integer> {

    int index = 0;

    int i1 = 1;
    int i2 = 1;

    int index2 = 0;

    @Override
    public Integer next() {
        return fib(index++);
    }

    public int next2() {
        if (index2++<2) {
            return 1;
        }    else {
            int r = i1+i2;
            i1 = i2;
            i2 = r;
            return r;
        }
    }

    public int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        long start = System.currentTimeMillis();
        for (int i=0 ;i<40; ++i) {
            System.out.print(fib.next() + " ");
        }
        System.out.println();
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        for (int i=0 ;i<40; ++i) {
            System.out.print(fib.next2() + " ");
        }
        System.out.println();
        System.out.println(System.currentTimeMillis() - start);
    }
}
