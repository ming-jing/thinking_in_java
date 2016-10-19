/**
 * Created by belows on 16/10/16.
 */

class Base11 {
    void test() {
        test2();
    }

    void test2() {
        System.out.println(
                "Base11.test()"
        );
    }
}

class Test11 extends Base11 {
    @Override
    void test2() {
        System.out.println("Test11.test()");
    }
}

public class Ex10 {

    public static void main(String[] args) {
        Base11 b = new Test11();
        b.test();
    }
}
