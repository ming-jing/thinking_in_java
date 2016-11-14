/**
 * Created by belows on 2016/11/11.
 */
/**
 *Create two interfaces and a class that implements both.
 *  Create two generic methods, one whose argument parameter is bounded by the first interface
 *  and one whose argument parameter is bounded by the second interface.
 *  Create an instance of the class that implements both interfaces,
 *  and show that it can be used with both generic methods.
 */

public class Ex25 {

    interface IT1 {
        void test1();
    }

    interface IT2 {
        void test2(int i);
    }

    static class Test implements IT1,IT2 {
        @Override
        public void test1() {
            System.out.println("Test.test1()");
        }

        @Override
        public void test2(int i) {
            System.out.println("Test.test2(" + i + ")");
        }
    }

    static <T extends IT1> void test1(T t) {
        t.test1();
    }

    static <T extends IT2> void test(T t) {
        t.test2(32);
    }


    public static void main(String[] args) {
        Test test = new Test();
        test1(test);
        test(test);
    }
}
