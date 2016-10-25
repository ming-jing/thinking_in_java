/**
 * Created by belows on 2016/10/24.
 */

interface I21 {
    void test();

    class StaticInner {
        static void f(I21 i21) {
            i21.test();
        }
    }
}
public class Ex21 {
    public static void main(String[] args) {
        I21.StaticInner.f(new I21() {
            @Override
            public void test() {
                System.out.println("I21 implement");
            }
        });
    }
}
