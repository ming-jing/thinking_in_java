/**
 * Created by belows on 2016/11/2.
 */
public class Ex25 {
    static class E1 extends Exception {}
    static class E2 extends E1 {}
    static class E3 extends E2 {}

    static class A {
        void test() throws E1 {

        }
    }

    static class B extends A {
        @Override
        void test() throws E2 {

        }
    }

    static class C extends B {
        @Override
        void test() throws E3 {

        }
    }

    public static void main(String[] args) {
        A c = new C();
        try {
            c.test();
        } catch (E1 e) {}
    }
}
