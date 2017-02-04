package ex.ex1;

/**
 * Created by belows on 2017/1/3.
 */
public class Ex1 {
    private static class Base {
        void test() {}
    }

    private static class Test extends Base {
        @Override
        void test() {
            super.test();
        }
    }
}
