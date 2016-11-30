/**
 * Created by belows on 2016/11/14.
 */
public class Ex34 {
    static abstract class SelfBound<T extends SelfBound<T> > {
        abstract T get(T t);

        void test(T t) {
            T t1 = get(t);
        }
    }

    static class Test extends SelfBound<Test> {
        @Override
        Test get(Test test) {
            return test;
        }
        public static void main(String[] args) {
            System.out.println("Test");
            new Test().test(new Test());
        }

    }

}
