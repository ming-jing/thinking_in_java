/**
 * Created by belows on 2016/10/24.
 */

interface I13 {
    void test();
}

public class Ex13 {

    static I13 getInstance() {
        return new I13() {
            @Override
            public void test() {
                System.out.println("test13");
            }
        };
    }
    public static void main(String[] args) {
        getInstance().test();
    }
}
