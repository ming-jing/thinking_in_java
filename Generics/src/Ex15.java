import java.util.ArrayList;
import java.util.List;

/**
 * Created by belows on 2016/11/10.
 */
public class Ex15 {
    static class TwoTuple<A,B> {
        final A a;
        final B b;
        public TwoTuple(A a, B b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return a + " " + b;
        }
    }

    static class ThreeTuple<A,B,C> extends TwoTuple<A,B> {
        final C c;
        public ThreeTuple(A a, B b, C c) {
            super(a,b);
            this.c = c;
        }
    }

    static class FourTuple<A,B,C,D> extends ThreeTuple<A,B,C> {

        final D d;
        public FourTuple(A a, B b, C c, D d) {
            super(a, b, c);
            this.d = d;
        }
    }

    static class FiveTuple<A,B,C,D,E> extends FourTuple<A,B,C,D> {

        final E e;
        public FiveTuple(A a, B b, C c, D d, E e) {
            super(a, b, c, d);
            this.e = e;
        }
    }

    static class SixTuple<A,B,C,D,E,F> extends FiveTuple<A,B,C,D,E> {
        final F f;
        public SixTuple(A a, B b, C c, D d, E e , F f) {
            super(a, b, c, d, e);
            this.f = f;
        }
    }

    static <A,B> TwoTuple<A,B> tuple(A a, B b) {
        return new TwoTuple<A, B>(a,b);
    }

    static <A,B,C> ThreeTuple<A,B,C> tuple(A a, B b, C c) {
        return new ThreeTuple(a,b,c);
    }

    static <A,B,C,D> FourTuple<A,B,C,D> tuple(A a, B b, C c, D d) {
        return new FourTuple<A, B, C, D>(a,b,c,d);
    }

    static <A,B,C,D,E> FiveTuple<A,B,C,D,E> tuple(A a,B b, C c, D d, E e) {
        return new FiveTuple<A, B, C, D, E>(a,b,c,d,e);
    }

    static <A,B,C,D,E,F> SixTuple<A,B,C,D,E,F> tuple(A a, B b, C c, D d, E e, F f) {
        return new SixTuple<A, B, C, D, E, F>(a,b,c,d,e,f);
    }

    static TwoTuple<String,Integer> f() {
        return tuple("hi", 47);
    }
    static TwoTuple f2() { return tuple("hi", 47); }

    public static void main(String[] args) {
        System.out.println(f());
        System.out.println(f2());
        TwoTuple f2 = f2();
        TwoTuple<String,String> fs = f2;
        List l = new ArrayList<Integer>();
        l.add(3);
        l.add(5);
        List<String> t = l;
        System.out.println(t);
        System.out.println(f2);
    }
}
