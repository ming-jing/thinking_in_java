/**
 * Created by belows on 16/10/16.
 */

abstract class Base4 {
    abstract void test();
}

class Test4 extends Base4 {
    void test() {
        System.out.println("Test4.test()");
    }
}

public class Ex4 {

    static void test(Base4 b) {
        b.test();
    }

    public static void main(String[] args) {
        test(new Test4());
    }
}
