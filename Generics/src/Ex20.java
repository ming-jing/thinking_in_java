import java.util.ArrayList;

/**
 * Created by belows on 2016/11/10.
 */
public class Ex20 {
    interface IT {
        void test1();
        void test2(int i);
    }

    static class T1 implements IT {
        @Override
        public void test1() {
            System.out.println("T1.test1()");
        }

        @Override
        public void test2(int i) {
            System.out.println("T1.test2()");
        }
    }

    <T extends IT> void  test(T t) {
        t.test1();
        t.test2(34);
    }

    static class Test<T extends CharSequence> {
        void test() {

        }

    }

    public static void main(String[] args) {
        new Ex20().test(new T1());

        System.out.println(new ArrayList<Integer>().getClass().getCanonicalName());
        System.out.println(new ArrayList<String>().getClass().getCanonicalName());
        System.out.println(new Test<String>().getClass().getCanonicalName());
        System.out.println(new Test<StringBuilder>().getClass().getCanonicalName());
        System.out.println(new Test<>().getClass().getCanonicalName());
    }
}
