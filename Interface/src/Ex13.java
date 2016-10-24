/**
 * Created by belows on 2016/10/19.
 */

interface inter1 {
    void test1();
}

interface inter2 extends inter1 {
    void test2();
}

interface inter3 extends inter1,inter2 {
    void test3();
}

public class Ex13 {

    public static void main(String[] args) {
        new inter3() {
            @Override
            public void test1() {

            }

            @Override
            public void test2() {

            }

            @Override
            public void test3() {

            }
        };
    }
}
