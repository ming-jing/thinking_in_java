/**
 * Created by belows on 2016/10/20.
 */

interface I9 {
    void f();
}


public class Ex9 {
    static I9 test() {
        class Test implements I9 {
            @Override
            public void f() {

            }
        }
        return new Test();
    }

    static I9 test2(int i) {
        if (i > 10) {
            class Test implements I9 {
                @Override
                public void f() {

                }
            }
            return new Test();
        }
        return null;
    }

    public static void main(String[] args) {
        I9 i9 = test();
        I9 i2 = test2(30);
    }
}
