/**
 * Created by belows on 2016/11/9.
 */
public class Ex3 {
    static class TwoTuple<A,B> {
        final A a;
        final B b;
        public TwoTuple(A a, B b) {
            this.a = a;
            this.b = b;
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

    public static void main(String[] args) {
        ThreeTuple<Integer,Integer,Integer> c = new ThreeTuple<>(1,2,3);
        System.out.println(c.a);
    }
}
