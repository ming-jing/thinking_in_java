/**
 * Created by belows on 2016/10/20.
 */
class Outer8 {

    interface TT {
        void test();
    }

    public TT getTT() {
        class TI implements TT {
            @Override
            public void test() {

            }
        }
        return new TI();
    }

    public void test(Inner inner) {
        System.out.println(inner.innerStr);
    }

    class Inner {
        private String innerStr;

        public Inner(String innerStr) {
            this.innerStr = innerStr;
        }
    }
}

public class Ex8 {
    public static void main(String[] s) {
        Outer8 outer8 = new Outer8();
        outer8.test(outer8.new Inner("Inner Access"));

        Outer8.TT t =  outer8.getTT();
        System.out.println(t.getClass().getSimpleName());
        int i = 0;
    }
}
